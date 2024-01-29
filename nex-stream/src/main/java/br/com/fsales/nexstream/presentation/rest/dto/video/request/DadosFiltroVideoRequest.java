package br.com.fsales.nexstream.presentation.rest.dto.video.request;

import java.time.LocalDate;

import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosFiltroVideoRequest(
    String titulo,

    String descricao,

    String categoria,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataPublicacao
) implements DadosFiltroDto {
}
