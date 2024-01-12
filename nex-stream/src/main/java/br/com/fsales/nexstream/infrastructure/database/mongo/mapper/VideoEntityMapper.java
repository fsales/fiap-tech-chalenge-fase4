package br.com.fsales.nexstream.infrastructure.database.mongo.mapper;

import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;

public final class VideoEntityMapper {

    private VideoEntityMapper() {
    }

    public static Video convertToVideo(VideoEntity videoEntity) {

        return new Video(new DadosCadastrarVideoDto() {

            @Override
            public String titulo() {
                return videoEntity.getTitulo();
            }

            @Override
            public String descricao() {
                return videoEntity.getDescricao();
            }

            @Override
            public String url() {
                return videoEntity.getUrl();
            }

            @Override
            public String id() {
                return videoEntity.getId();
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
