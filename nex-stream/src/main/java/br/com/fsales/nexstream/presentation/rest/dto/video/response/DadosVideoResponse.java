package br.com.fsales.nexstream.presentation.rest.dto.video.response;

import java.time.LocalDate;

import br.com.fsales.nexstream.presentation.rest.dto.video.response.swagger.DadosVideoResponseSwagger;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosVideoResponse(
        String id,
        String titulo,
        String descricao,
        String url,
        String categoria,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataPublicacao
) implements DadosVideoResponseSwagger {

}
