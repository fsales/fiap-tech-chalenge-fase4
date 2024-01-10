package br.com.fsales.nexstream.infrastructure.database.mongo.mapper;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;
import br.com.fsales.nexstream.usecase.video.DadosCadastrarVideo;

public final class VideoEntityMapper {

    public static Video convertToVideo(VideoEntity videoEntity) {

        return new Video(new DadosCadastrarVideo() {

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

    public static VideoEntity convertToVideoEntity(Video video) {

        return new VideoEntity(
                video.getTitulo(),
                video.getDescricao(),
                video.getUrl(),
                video.getDataPublicacao()
        );
    }

}
