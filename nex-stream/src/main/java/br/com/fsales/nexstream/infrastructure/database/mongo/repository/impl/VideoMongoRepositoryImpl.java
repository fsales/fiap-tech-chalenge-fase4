package br.com.fsales.nexstream.infrastructure.database.mongo.repository.impl;

import java.util.regex.Pattern;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;
import br.com.fsales.nexstream.infrastructure.database.mongo.mapper.VideoEntityMapper;
import br.com.fsales.nexstream.infrastructure.database.mongo.repository.PageRepositoryCustom;
import br.com.fsales.nexstream.infrastructure.database.mongo.repository.VideoMongoRepositoryCustom;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class VideoMongoRepositoryImpl implements VideoMongoRepositoryCustom<VideoEntity>, PageRepositoryCustom<VideoEntity> {
    // https://docs.spring.io/spring-data/mongodb/reference/repositories/custom-implementations.html
    // https://mhewedy.github.io/spring-data-jpa-mongodb-expressions/

    private final ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<Pagina<Video>> consultaPaginada(DadosFiltroDto filtro, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var criteria = new Criteria();
        var query = new Query(criteria);


        if (StringUtils.isNotBlank(filtro.titulo())) {
            criteria.and("titulo").regex("(?i).*" + Pattern.quote(filtro.titulo()) + ".*");
        }

        if (filtro.dataPublicacao() != null) {
            criteria.and("dataPublicacao").is(filtro.dataPublicacao());
        }

        if (StringUtils.isNotBlank(filtro.categoria())) {
            criteria.and("categoria.titulo").regex("(?i).*" + Pattern.quote(filtro.categoria()) + ".*");
        }

        var sort = Sort.by(Sort.Order.asc("dataPublicacao"));

        var dados = consultaDocumentosPaginado(query, mongoTemplate, VideoEntity.class, pageable, sort);

        return dados.map(videoEntityPage -> videoEntityPage.map(VideoEntityMapper::convertToVideo));
    }
}
