package br.com.fsales.nexstream.domain.core.video.model;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = {"url", "titulo"})
@ToString(of = {"url", "titulo"})
public class Video {
    private final String id;
    private final String titulo;
    private final String descricao;
    private final String url;
    private final LocalDateTime dataPublicacao;
    private final Categoria categoria;


    public Video(DadosCadastrarVideoDto dados, Categoria categoria) {
        Objects.requireNonNull(dados, "Dados para criação do vídeo são obrigatórios!");
        Objects.requireNonNull(dados.titulo(), "Título do vídeo é obrigatório!");
        Objects.requireNonNull(dados.descricao(), "Descrição do vídeo é obrigatório!");
        Objects.requireNonNull(dados.url(), "URL do vídeo é obrigatório!");

        Objects.requireNonNull(categoria, "Categoria do vídeo é obrigatório!");

        this.dataPublicacao = LocalDateTime.now();
        this.id = dados.id();

        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();

        this.categoria = categoria;

    }
}
