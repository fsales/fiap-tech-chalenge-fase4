package br.com.fsales.nexstream.usecase.categoria.impl;

import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.categoria.repository.CategoriaRepository;
import br.com.fsales.nexstream.usecase.categoria.DetalharCategoriaPorIdUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DetalharCategoriaPorIdPorIdService implements DetalharCategoriaPorIdUseCase {

    private final CategoriaRepository categoriaRepository;

    public DetalharCategoriaPorIdPorIdService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Mono<Categoria> execute(String id) {

        if (id == null || id.isEmpty()) {
            return Mono.error(new IllegalArgumentException("ID é obrigatório."));
        }

        return categoriaRepository
                .detalhar(id)
                .switchIfEmpty(
                        Mono.error(new RegraDeNegocioException("Categoria não encontrada."))
                );
    }
}
