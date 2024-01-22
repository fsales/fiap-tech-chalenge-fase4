package br.com.fsales.nexstream.presentation.rest.dto.categoria.response;

import br.com.fsales.nexstream.presentation.rest.dto.categoria.response.swagger.DadosCategoriaResponseSwagger;

public record DadosCategoriaResponse(
        String id,
        String titulo
) implements DadosCategoriaResponseSwagger {
}
