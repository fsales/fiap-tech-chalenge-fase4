package br.com.fsales.nexstream.usecase.video;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import reactor.core.publisher.Mono;

public interface CadastrarVideoUseCase {
    Mono<Video> execute(DadosCadastrarVideo dados);
}
