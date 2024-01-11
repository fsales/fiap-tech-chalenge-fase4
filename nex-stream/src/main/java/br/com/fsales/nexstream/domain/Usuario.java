package br.com.fsales.nexstream.domain;

import br.com.fsales.nexstream.domain.core.video.model.Video;

import java.util.Set;

public class Usuario {
    private String id;
    private String nome;
    private Set<Video> videosFavoritos;
}
