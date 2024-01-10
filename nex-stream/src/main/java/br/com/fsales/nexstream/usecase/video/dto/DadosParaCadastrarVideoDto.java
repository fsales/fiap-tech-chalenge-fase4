package br.com.fsales.nexstream.usecase.video.dto;

public record DadosParaCadastrarVideoDto(
        String titulo,
        String descricao,
        String url
) {
}
