package br.com.fsales.nexstream.presentation.rest.dto.categoria.request;

import br.com.fsales.nexstream.presentation.rest.dto.categoria.request.swagger.DadosParaCadastrarCategoriaRequestSwagger;
import br.com.fsales.nexstream.presentation.rest.validation.groups.CreateInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosParaCadastrarCategoriaRequest(
        @NotNull(message = "Título da categoria é obrigatório.", groups = {CreateInfo.class})
        @Size(min = 1, max = 100, message = "Título deve ter no mínino {min} e  máximo {max} caracteres.", groups = {CreateInfo.class})
        String titulo
) implements DadosParaCadastrarCategoriaRequestSwagger {
}
