package br.com.fsales.nexstream.usecase.video.impl;

import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.DeleteVideoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DeleteVideoService implements DeleteVideoUseCase {

    private final VideoRepository videoRepository;

    public DeleteVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Mono<Void> execute(String id) {
        if (StringUtils.isEmpty(id)) {
            return Mono.error(new RegraDeNegocioException("Todos os campos do vídeo são obrigatórios."));
        }
        return videoRepository
                .delete(id)
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }
}
