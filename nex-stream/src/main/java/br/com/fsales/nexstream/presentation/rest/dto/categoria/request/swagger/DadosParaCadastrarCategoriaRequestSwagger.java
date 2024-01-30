package br.com.fsales.nexstream.presentation.rest.dto.categoria.request.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface DadosParaCadastrarCategoriaRequestSwagger {
    @Schema(description = "Título da categoria", required = true, example = "Drama")
    String titulo();
}
