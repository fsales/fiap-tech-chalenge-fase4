package br.com.fsales.nexstream.usecase.video.impl;

import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.DetalharVideoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DetalharVideoService implements DetalharVideoUseCase {

    private final VideoRepository videoRepository;

    public DetalharVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Mono<Video> execute(String id) {
        if (StringUtils.isEmpty(id)) {
            return Mono.error(new RegraDeNegocioException("Todos os campos do vídeo são obrigatórios."));
        }

        return videoRepository
                .detalhar(id)
                .switchIfEmpty(Mono.error(new RegraDeNegocioException("Registro não encontrado")))
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }
}
