package br.com.fsales.nexstream.usecase.video;

import reactor.core.publisher.Mono;

public interface DeleteVideoUseCase {

    Mono<Void> execute(String id);
}
