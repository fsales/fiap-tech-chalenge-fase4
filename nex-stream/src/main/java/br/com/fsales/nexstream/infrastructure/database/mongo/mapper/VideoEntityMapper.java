package br.com.fsales.nexstream.infrastructure.database.mongo.mapper;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.CategoriaEntity;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;

public final class VideoEntityMapper {

    private VideoEntityMapper() {
    }

    public static Video convertToVideo(VideoEntity videoEntity) {

        var categoria = videoEntity.getCategoria();
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
        },
                new Categoria(new DadosCadastroCategoriaDto() {
                    @Override
                    public String id() {
                        return categoria.getId();
                    }

                    @Override
                    public String titulo() {
                        return categoria.getTitulo();
                    }
                }));
    }

    public static VideoEntity convertToVideoEntity(Video video) {
        var categoria = video.getCategoria();
        return new VideoEntity(
                video.getTitulo(),
                video.getDescricao(),
                video.getUrl(),
                video.getDataPublicacao(),
                CategoriaEntity
                        .builder()
                        .id(categoria.getId())
                        .titulo(categoria.getTitulo())
                        .build()
        );
    }

}
