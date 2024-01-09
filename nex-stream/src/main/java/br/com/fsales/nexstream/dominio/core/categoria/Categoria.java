package br.com.fsales.nexstream.dominio.core.categoria;

import java.util.HashSet;
import java.util.Set;

import br.com.fsales.nexstream.dominio.core.video.model.Video;

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
