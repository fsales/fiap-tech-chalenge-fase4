package br.com.fsales.nexstream.usecase.video.impl;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.ConsultarVideoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ConsultarVideoService implements ConsultarVideoUseCase {

    private final VideoRepository videoRepository;

    public ConsultarVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Mono<Pagina<Video>> execute(DadosFiltroDto filtro, int pageNumber, int pageSize) {


        return videoRepository.listarTodos(filtro, pageNumber, pageSize);
    }
}
