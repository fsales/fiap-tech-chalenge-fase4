package br.com.fsales.nexstream.domain.core.video.dto;

import java.time.LocalDate;

public interface DadosFiltroDto {
    String titulo();

    String descricao();

    String categoria();

    LocalDate dataPublicacao();
}
