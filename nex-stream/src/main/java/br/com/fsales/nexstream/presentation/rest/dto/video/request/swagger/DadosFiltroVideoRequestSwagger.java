package br.com.fsales.nexstream.presentation.rest.dto.video.request.swagger;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public interface DadosFiltroVideoRequestSwagger {
    @Schema(description = "Categoria do vídeo", required = true, example = "Drama")
    String categoria();

    @Schema(description = "Título do vídeo", required = true, example = "Oppenheimer")
    String titulo();

    @Schema(description = "Descrição do vídeo", required = true, example = "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.")
    String descricao();

    @Schema(description = "Data de publicação do vídeo", required = true, example = "29/01/2024")
    LocalDate dataPublicacao();
}
