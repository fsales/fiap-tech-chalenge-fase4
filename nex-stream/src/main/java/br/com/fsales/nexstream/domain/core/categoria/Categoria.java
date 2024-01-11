package br.com.fsales.nexstream.domain.core.categoria;

import br.com.fsales.nexstream.domain.core.video.model.Video;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private String codigo;
    private String nome;

    private Set<Video> videos = new HashSet<>();

  /*  public Categoria(String nome){
        this.codigo =
    }*/

    public void registrarVideo(Video video){
        this.videos.add(video);
    }
}
