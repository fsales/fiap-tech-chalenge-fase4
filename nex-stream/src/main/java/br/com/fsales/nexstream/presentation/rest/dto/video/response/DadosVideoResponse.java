package br.com.fsales.nexstream.presentation.rest.dto.video.response;

import br.com.fsales.nexstream.presentation.rest.dto.video.response.swagger.DadosVideoResponseSwagger;

public record DadosVideoResponse(
        String id,
        String titulo,
        String descricao,
        String url,
        String categoria
) implements DadosVideoResponseSwagger {

}
