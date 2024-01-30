package br.com.fsales.nexstream.usecase.categoria;

import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import reactor.core.publisher.Mono;

public interface DetalharCategoriaPorIdUseCase {

    Mono<Categoria> execute(String id);
}
