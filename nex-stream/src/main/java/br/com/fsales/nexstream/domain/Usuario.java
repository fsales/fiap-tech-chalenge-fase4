package br.com.fsales.nexstream.domain;

import java.util.Set;

import br.com.fsales.nexstream.domain.core.video.model.Video;

public class Usuario {
    private String id;
    private String nome;
    private Set<Video> videosFavoritos;
}
