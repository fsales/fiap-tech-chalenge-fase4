package br.com.fsales.nexstream.dominio.core.video.repository;

import br.com.fsales.nexstream.dominio.core.video.model.Video;

public interface VideoRepository {
    Video save(Video video);
}
