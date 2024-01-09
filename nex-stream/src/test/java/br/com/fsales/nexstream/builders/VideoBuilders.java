package br.com.fsales.nexstream.builders;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.usecase.DadosCadastrarVideo;

public class VideoBuilders {

    public static Video build(
            String codigo,
            String titulo,
            String descricao,
            String url

    ) {
        return new Video(new DadosCadastrarVideo() {
            @Override
            public String codigo() {
                return codigo;
            }

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
        });
    }
}
