package br.com.fsales.nexstream.infrastructure.spring;

import br.com.fsales.nexstream.dominio.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.impl.CadastrarVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCaseBeansConfiguration {

    private final VideoRepository videoRepository;
    @Bean
    public CadastrarVideoUseCase cadastrarVideoUseCase(){
        return new CadastrarVideoService(videoRepository);
    }
}

