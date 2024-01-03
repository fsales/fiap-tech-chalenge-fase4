package br.com.fsales.nexstream.dominio;

import java.util.Set;

import br.com.fsales.nexstream.dominio.core.video.model.Video;

public class Usuario {
    private String id;
    private String nome;
    private Set<Video> videosFavoritos;
}
