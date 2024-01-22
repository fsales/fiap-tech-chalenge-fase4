package br.com.fsales.nexstream.usecase.categoria.impl;

import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.categoria.repository.CategoriaRepository;
import br.com.fsales.nexstream.usecase.categoria.CadastrarCategoriaUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CadastrarCategoriaService implements CadastrarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public CadastrarCategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Mono<Categoria> execute(DadosCadastroCategoriaDto dados) {

        return validarDados(dados)
                .then(Mono.defer(() -> {
                    Mono<Boolean> tituloCadastradoMono = categoriaRepository.tituloJaCadastrado(dados.titulo());
                    return tituloCadastradoMono != null ? tituloCadastradoMono : Mono.just(false);
                }))
                .flatMap(categoriaJaCadastrada -> {
                    if (categoriaJaCadastrada) {
                        return Mono.error(new RegraDeNegocioException("Cadastro não realizado: Título já cadastrado."));
                    }
                    var categoria = new Categoria(dados);
                    return categoriaRepository.cadastrar(categoria);
                })
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }


    private Mono<Void> validarDados(DadosCadastroCategoriaDto dados) {
        if (dados.titulo() == null) {
            return Mono.error(new RegraDeNegocioException("Todos os campos da categoria são obrigatórios."));
        }
        return Mono.empty();
    }
}
