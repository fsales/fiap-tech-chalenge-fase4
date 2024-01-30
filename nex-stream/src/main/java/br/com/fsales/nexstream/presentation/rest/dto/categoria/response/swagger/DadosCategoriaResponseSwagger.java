package br.com.fsales.nexstream.presentation.rest.dto.categoria.response.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface DadosCategoriaResponseSwagger {
    @Schema(description = "ID", required = true, example = "65b11b654e38a32197dbd087")
    String id();

    @Schema(description = "Título da categoria", required = true, example = "Drama")
    String titulo();
}
