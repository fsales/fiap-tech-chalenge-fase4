package br.com.fsales.nexstream.infrastructure.persistence.spring;

import br.com.fsales.nexstream.application.video.CadastrarVideoService;
import br.com.fsales.nexstream.dominio.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.dominio.core.video.usecase.dto.CadastrarVideoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeansConfiguration {

    @Bean
    public CadastrarVideoUseCase cadastrarVideoUseCase(
            VideoRepository videoRepository
    ){
        return new CadastrarVideoService(videoRepository);
    }
}

