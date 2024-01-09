package br.com.fsales.nexstream.infrastructure.persistence.jpa.repository;

import java.util.Objects;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.infrastructure.persistence.jpa.entity.VideoEntity;
import br.com.fsales.nexstream.infrastructure.persistence.mapper.VideoEntityMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VideoJpaRepository extends VideoRepository, ReactiveMongoRepository<VideoEntity, String> {

    Mono<Boolean> existsByTituloIgnoreCase(String titulo);

    @Override
    default Mono<Video> cadastrar(Video video){
        var videoEntity = VideoEntity.entityBuilder().fromVideo(video).build();

        var monoVideoEntity = this.save(videoEntity);

        return monoVideoEntity.map(VideoEntityMapper::convertToVideo);
    }

    @Override
    default Mono<Boolean> tituloJaCadastrado(String titulo){
        if(Objects.isNull(titulo) || StringUtils.isEmpty(titulo))
            return Mono.just(Boolean.FALSE);

        return this.existsByTituloIgnoreCase(titulo);
    }
}
