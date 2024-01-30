package br.com.fsales.nexstream.usecase.video;

import br.com.fsales.nexstream.domain.core.video.model.Video;
import reactor.core.publisher.Mono;

public interface DetalharVideoUseCase {

    Mono<Video> execute(String id);
}
