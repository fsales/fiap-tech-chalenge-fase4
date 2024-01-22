package br.com.fsales.nexstream.usecase.categoria.dto;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;

public record DadosParaCadastrarCategoriaDtoPort(
        String titulo
) implements DadosCadastroCategoriaDto {
}
