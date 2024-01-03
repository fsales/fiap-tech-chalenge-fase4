package br.com.fsales.nexstream.dominio.core.video.usecase;

import br.com.fsales.nexstream.dominio.core.video.model.Video;

public interface CadastrarVideoUseCase {
    Video save(Video video);
}
