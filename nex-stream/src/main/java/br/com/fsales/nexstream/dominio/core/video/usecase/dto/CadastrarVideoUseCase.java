package br.com.fsales.nexstream.dominio.core.video.usecase.dto;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.usecase.DadosCadastrarVideo;
import reactor.core.publisher.Mono;

public interface CadastrarVideoUseCase {
    Mono<Video> execute(DadosCadastrarVideo dados);
}
