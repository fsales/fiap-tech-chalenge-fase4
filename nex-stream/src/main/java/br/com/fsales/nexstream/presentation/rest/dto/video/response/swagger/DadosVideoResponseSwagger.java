package br.com.fsales.nexstream.presentation.rest.dto.video.response.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public interface DadosVideoResponseSwagger {
    @Schema(description = "ID", required = true, example = "65aeb8dbe02f3659e829c6d5")
    String id();

    @Schema(description = "Título do vídeo", required = true, example = "Oppenheimer")
    String titulo();

    @Schema(description = "Descrição do vídeo", required = true, example = "A história do envolvimento de J. Robert Oppenheimer na criação da bomba atómica durante a Segunda Guerra Mundial.")
    String descricao();

    @Schema(description = "URL do vídeo", required = true, example = "https://www.themoviedb.org/movie/872585-oppenheimer/watch#play=ILAwV65XuGA")
    String url();

    @Schema(description = "Categoria do vídeo", required = true, example = "Drama")
    String categoria();
}
