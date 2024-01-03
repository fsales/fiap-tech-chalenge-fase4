package br.com.fsales.nexstream.application.video;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.dominio.core.video.usecase.CadastrarVideoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarVideoService implements CadastrarVideoUseCase {

    private final VideoRepository videoRepository;
    @Override
    public Video save(Video video) {

        return videoRepository.save(video);
    }
}
