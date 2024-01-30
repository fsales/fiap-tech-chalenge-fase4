package br.com.fsales.nexstream.presentation.rest.mapper.categoria;

import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.presentation.rest.dto.categoria.request.DadosParaCadastrarCategoriaRequest;
import br.com.fsales.nexstream.presentation.rest.dto.categoria.response.DadosCategoriaResponse;
import br.com.fsales.nexstream.usecase.categoria.dto.DadosParaCadastrarCategoriaDtoPort;

public final class CategoriaDtoMapper {

    private CategoriaDtoMapper() {
    }

    public static DadosParaCadastrarCategoriaDtoPort convertDadosParaCadastrarCategoriaRequestToDadosParaCadastrarCategoriaPort(
            DadosParaCadastrarCategoriaRequest request
    ) {

        return new DadosParaCadastrarCategoriaDtoPort(
                request.titulo()
        );
    }

    public static DadosCategoriaResponse convertCategoriaToDadosCategoriaResponse(
            Categoria categoria
    ) {

        return new DadosCategoriaResponse(
                categoria.getId(),
                categoria.getTitulo()
        );
    }

}
