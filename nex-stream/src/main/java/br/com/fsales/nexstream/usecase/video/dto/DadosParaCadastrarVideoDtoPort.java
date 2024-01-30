package br.com.fsales.nexstream.usecase.video.dto;

import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;

public record DadosParaCadastrarVideoDtoPort(
        String titulo,
        String descricao,
        String categoria,
        String url
) implements DadosCadastrarVideoDto {

}
