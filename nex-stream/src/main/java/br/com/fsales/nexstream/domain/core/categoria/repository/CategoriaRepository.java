package br.com.fsales.nexstream.domain.core.categoria.repository;

import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import reactor.core.publisher.Mono;

public interface CategoriaRepository {

    Mono<Categoria> cadastrar(Categoria categoria);

    Mono<Boolean> tituloJaCadastrado(String titulo);

    Mono<Categoria> detalhar(String id);
}
