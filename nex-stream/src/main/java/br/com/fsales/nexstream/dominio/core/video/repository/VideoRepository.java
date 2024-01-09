package br.com.fsales.nexstream.dominio.core.video.repository;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import reactor.core.publisher.Mono;

public interface VideoRepository {
    Mono<Video> cadastrar(Video video);

    Mono<Boolean> tituloJaCadastrado(String titulo);
}
