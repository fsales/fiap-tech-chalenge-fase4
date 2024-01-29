package br.com.fsales.nexstream.infrastructure.database.mongo.adapter;

import java.util.Objects;

import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.categoria.repository.CategoriaRepository;
import br.com.fsales.nexstream.infrastructure.database.mongo.mapper.CategoriaEntityMapper;
import br.com.fsales.nexstream.infrastructure.database.mongo.repository.CategoriaMongoRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoriaAdapter implements CategoriaRepository {

    private final CategoriaMongoRepository repository;

    @Override
    public Mono<Categoria> cadastrar(Categoria categoria) {

        var categoriaEntity = CategoriaEntityMapper.convertToCategoriaEntity(categoria);

        var monoCategoriaEntity = repository.save(categoriaEntity);

        return monoCategoriaEntity
                .map(CategoriaEntityMapper::convertToCategoria);
    }

    @Override
    public Mono<Boolean> tituloJaCadastrado(String titulo) {
        if (Objects.isNull(titulo) || StringUtils.isEmpty(titulo))
            return Mono.just(Boolean.FALSE);

        return repository.existsByTituloIgnoreCase(titulo);
    }

    @Override
    public Mono<Categoria> detalhar(String id) {
        return repository
                .findById(id)
                .map(CategoriaEntityMapper::convertToCategoria);
    }

    @Override
    public Mono<Categoria> detalharPorTitulo(String titulo) {
        return repository
                .findByTituloIgnoreCase(titulo)
                .map(CategoriaEntityMapper::convertToCategoria);
    }
}
