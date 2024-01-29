package br.com.fsales.nexstream.domain.core.video.repository;

import br.com.fsales.nexstream.domain.core.video.model.Video;
import reactor.core.publisher.Mono;

public interface VideoRepository {

    Mono<Video> cadastrar(Video video);

    Mono<Video> atualizar(Video video);

    Mono<Video> detalhar(String id);

    Mono<Boolean> tituloJaCadastrado(String titulo);

    Mono<Boolean> tituloJaCadastradoIgnorandoId(String titulo, String id);
}
