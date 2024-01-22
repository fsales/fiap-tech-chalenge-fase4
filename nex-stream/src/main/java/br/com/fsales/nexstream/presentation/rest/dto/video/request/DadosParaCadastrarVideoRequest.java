package br.com.fsales.nexstream.presentation.rest.dto.video.request;

import br.com.fsales.nexstream.presentation.rest.dto.video.request.swagger.DadosParaCadastrarVideoRequestRequest;
import br.com.fsales.nexstream.presentation.rest.validation.groups.CreateInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record DadosParaCadastrarVideoRequest(
        @NotNull(message = "Título do vídeo é obrigatório.", groups = {CreateInfo.class})
        @Size(min = 10, max = 100, message = "Título deve ter no mínino {min} e  máximo {max} caracteres.", groups = {CreateInfo.class})
        String titulo,
        @NotNull(message = "Descrição do vídeo é obrigatório.", groups = {CreateInfo.class})
        @Size(min = 10, max = 255, message = "Descrição deve ter no máximo {max} caracteres.", groups = {CreateInfo.class})
        String descricao,
        @NotNull(message = "url do vídeo é obrigatório.", groups = {CreateInfo.class})
        @Size(min = 10, max = 255, message = "url deve ter no máximo {max} caracteres.", groups = {CreateInfo.class})
        @URL(message = "url inválida", groups = {CreateInfo.class})
        String url
) implements DadosParaCadastrarVideoRequestRequest {
}



