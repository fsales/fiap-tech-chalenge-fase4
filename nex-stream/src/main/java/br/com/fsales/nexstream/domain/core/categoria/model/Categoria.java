package br.com.fsales.nexstream.domain.core.categoria.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = {"titulo"})
@ToString(of = {"titulo"})
public class Categoria {
    private final String id;
    private final String titulo;
    private final Set<Video> videos = new HashSet<>();

    public Categoria(DadosCadastroCategoriaDto dados) {
        Objects.requireNonNull(dados, "Dados para criação da categoria são obrigatórios!");
        Objects.requireNonNull(dados.titulo(), "Título da categoria é obrigatório!");

        this.id = dados.id();
        this.titulo = dados.titulo();
    }

  /*  public Categoria(String nome){
        this.titulo =
    }*/

    public void registrarVideo(Video video) {
        this.videos.add(video);
    }
}
