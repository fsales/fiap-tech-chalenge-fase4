package br.com.fsales.nexstream.usecase.categoria;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import reactor.core.publisher.Mono;

public interface CadastrarCategoriaUseCase {

    Mono<Categoria> execute(DadosCadastroCategoriaDto dados);
}
