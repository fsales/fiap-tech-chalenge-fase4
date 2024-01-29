package br.com.fsales.nexstream.builders;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;


public class VideoBuilders {

    public static Video build(
            String id,
            String titulo,
            String descricao,
            String url,
            String idCategoria,
            String categoria

    ) {
        return new Video(new DadosCadastrarVideoDto() {

            @Override
            public String titulo() {
                return titulo;
            }

            @Override
            public String descricao() {
                return descricao;
            }

            @Override
            public String url() {
                return url;
            }

            @Override
            public String id() {
                return id;
            }
        }, new Categoria(new DadosCadastroCategoriaDto() {
            @Override
            public String id() {
                return idCategoria;
            }

            @Override
            public String titulo() {
                return categoria;
            }
        }));
    }
}
