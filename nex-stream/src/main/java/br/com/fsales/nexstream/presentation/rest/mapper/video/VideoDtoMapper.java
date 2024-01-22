package br.com.fsales.nexstream.presentation.rest.mapper.video;

import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosParaCadastrarVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.response.DadosVideoResponse;
import br.com.fsales.nexstream.usecase.video.dto.DadosParaCadastrarVideoDtoPort;

public final class VideoDtoMapper {

    private VideoDtoMapper() {
    }

    public static DadosParaCadastrarVideoDtoPort convertDadosParaCadastrarVideoRequestToDadosParaCadastrarVideoPort(
            DadosParaCadastrarVideoRequest request
    ) {

        return new DadosParaCadastrarVideoDtoPort(
                request.titulo(),
                request.descricao(),
                request.url()
        );
    }

    public static DadosVideoResponse convertVideoToDadosVideoResponse(
            Video video
    ) {

        return new DadosVideoResponse(
                video.getId(),
                video.getTitulo(),
                video.getDescricao(),
                video.getUrl()
        );
    }
}
