package br.com.fsales.nexstream.domain.core.categoria.dto;

public interface DadosCadastroCategoriaDto {
    String titulo();

    default String id() {
        return null;
    }
}
