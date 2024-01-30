package br.com.fsales.nexstream.presentation.rest.dto.video.request;

import br.com.fsales.nexstream.presentation.rest.dto.video.request.swagger.DadosParaCadastrarVideoRequestSwagger;
import br.com.fsales.nexstream.presentation.rest.validation.groups.CreateInfo;
import br.com.fsales.nexstream.presentation.rest.validation.groups.UpdateInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record DadosParaCadastrarVideoRequest(
        @NotNull(message = "Título do vídeo é obrigatório.", groups = {CreateInfo.class, UpdateInfo.class})
        @Size(max = 100, message = "Título deve ter no mínino {min} e  máximo {max} caracteres.", groups = {CreateInfo.class, UpdateInfo.class})
        String titulo,
        @NotNull(message = "Descrição do vídeo é obrigatório.", groups = {CreateInfo.class, UpdateInfo.class})
        @Size(max = 255, message = "Descrição deve ter no máximo {max} caracteres.", groups = {CreateInfo.class, UpdateInfo.class})
        String descricao,
        @NotNull(message = "Categoria do vídeo é obrigatório.", groups = {CreateInfo.class, UpdateInfo.class})
        @Size(max = 100, message = "Categoria deve ter no máximo {max} caracteres.", groups = {CreateInfo.class, UpdateInfo.class})
        String categoria,
        @NotNull(message = "url do vídeo é obrigatório.", groups = {CreateInfo.class, UpdateInfo.class})
        @Size(max = 255, message = "url deve ter no máximo {max} caracteres.", groups = {CreateInfo.class, UpdateInfo.class})
        @URL(message = "url inválida", groups = {CreateInfo.class, UpdateInfo.class})
        String url
) implements DadosParaCadastrarVideoRequestSwagger {
}



