package br.com.fsales.nexstream.dominio.core.video.model;

import java.time.LocalDateTime;
import java.util.Set;

import br.com.fsales.nexstream.dominio.Categoria;

public class Video {
    private String id;
    private String titulo;
    private String descricao;
    private String url;
    private LocalDateTime dataPublicacao;
    private Set<Categoria> categorias;
}
