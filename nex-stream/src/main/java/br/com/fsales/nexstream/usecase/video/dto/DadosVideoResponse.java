package br.com.fsales.nexstream.usecase.video.dto;

import br.com.fsales.nexstream.domain.core.video.model.Video;

public record DadosVideoResponse (
        String id,
        String titulo,
        String descricao,
        String url
) {

    public DadosVideoResponse(Video video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getDescricao());
    }
}
