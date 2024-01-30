package br.com.fsales.nexstream.domain.core.video.dto;

public interface DadosCadastrarVideoDto {

    String titulo();

    String descricao();

    String url();

    default String id() {
        return null;
    }

    default String categoria() {
        return null;
    }

}
