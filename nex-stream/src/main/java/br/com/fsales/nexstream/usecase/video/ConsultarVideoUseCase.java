package br.com.fsales.nexstream.usecase.video;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import reactor.core.publisher.Mono;


public interface ConsultarVideoUseCase {
    Mono<Pagina<Video>> execute(DadosFiltroDto filtro, int pageNumber, int pageSize);
}
