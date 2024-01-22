package br.com.fsales.nexstream.infrastructure.database.mongo.adapter;

import java.util.Objects;

import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.infrastructure.database.mongo.mapper.VideoEntityMapper;
import br.com.fsales.nexstream.infrastructure.database.mongo.repository.VideoMongoRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class VideoRepositoryAdapter implements VideoRepository {

    private final VideoMongoRepository repository;

    @Override
    public Mono<Video> cadastrar(Video video) {

        var videoEntity = VideoEntityMapper.convertToVideoEntity(video);

        var monoVideoEntity = repository.save(videoEntity);

        return monoVideoEntity.map(VideoEntityMapper::convertToVideo);
    }

    @Override
    public Mono<Boolean> tituloJaCadastrado(String titulo) {
        if (Objects.isNull(titulo) || StringUtils.isEmpty(titulo))
            return Mono.just(Boolean.FALSE);

        return repository.existsByTituloIgnoreCase(titulo);
    }
}
