package br.com.fsales.nexstream.usecase.video.dto;

import br.com.fsales.nexstream.usecase.video.DadosCadastrarVideo;

public record DadosParaCadastrarVideoPort(
        String titulo,
        String descricao,
        String url
) implements DadosCadastrarVideo {

    public DadosParaCadastrarVideoPort (DadosParaCadastrarVideoDto dados){
         this(dados.titulo(), dados.descricao(), dados.titulo());
    }
}
