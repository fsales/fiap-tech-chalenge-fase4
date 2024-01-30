package br.com.fsales.nexstream;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ActiveProfiles("test")
public class TestMongoConfig {

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return Mockito.mock(ReactiveMongoTemplate.class);
    }
}