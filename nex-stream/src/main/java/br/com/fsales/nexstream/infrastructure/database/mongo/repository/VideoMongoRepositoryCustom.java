package br.com.fsales.nexstream.infrastructure.database.mongo.repository;


import br.com.fsales.nexstream.domain.core.page.Pagina;
import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import reactor.core.publisher.Mono;

public interface VideoMongoRepositoryCustom<VideoEntity> {

    Mono<Pagina<Video>> consultaPaginada(DadosFiltroDto filtro, int pageNumber, int pageSize);
}
