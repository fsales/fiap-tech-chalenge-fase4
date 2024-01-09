package br.com.fsales.nexstream.infrastructure.persistence.mapper;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.usecase.DadosCadastrarVideo;
import br.com.fsales.nexstream.infrastructure.persistence.jpa.entity.VideoEntity;

public final class VideoEntityMapper {

    public static Video convertToVideo(VideoEntity videoEntity){

        return new Video(new DadosCadastrarVideo() {
            @Override
            public String codigo() {
                return videoEntity.getCodigo();
            }

            @Override
            public String titulo() {
                return videoEntity.getId();
            }

            @Override
            public String descricao() {
                return videoEntity.getDescricao();
            }

            @Override
            public String url() {
                return videoEntity.getUrl();
            }
        });
    }

}
