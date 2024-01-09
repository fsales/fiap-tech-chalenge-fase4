package br.com.fsales.nexstream.dominio.core.video.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import br.com.fsales.nexstream.dominio.core.video.usecase.DadosCadastrarVideo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "codigo")
@ToString(of = {"codigo", "titulo"})
public class Video {
    private final String codigo;
    private final String titulo;
    private final String descricao;
    private final String url;
    private final LocalDateTime dataPublicacao;


    public Video(DadosCadastrarVideo dados) {
        Objects.requireNonNull(dados, "Dados para criação do vídeo são obrigatórios!");
        Objects.requireNonNull(dados.codigo(), "Código do vídeo é obrigatório!");
        Objects.requireNonNull(dados.titulo(), "Título do vídeo é obrigatório!");
        Objects.requireNonNull(dados.descricao(), "Descrição do vídeo é obrigatório!");
        Objects.requireNonNull(dados.url(), "URL do vídeo é obrigatório!");

        this.codigo = UUID.randomUUID().toString();
        this.dataPublicacao = LocalDateTime.now();

        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();

    }


}
