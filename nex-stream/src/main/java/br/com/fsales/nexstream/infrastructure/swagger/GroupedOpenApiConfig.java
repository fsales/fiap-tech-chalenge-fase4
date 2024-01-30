package br.com.fsales.nexstream.infrastructure.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupedOpenApiConfig {

    private static final String PATH_POSFIXO = "/**";

    @Bean
    public GroupedOpenApi categoriaOpenApi() {
        String[] paths = {String.format("/%s%s", "categorias", PATH_POSFIXO)};
        return GroupedOpenApi.builder().group("Categoria").pathsToMatch(paths).build();
    }

    @Bean
    public GroupedOpenApi videoOpenApi() {
        String[] paths = {String.format("/%s%s", "videos", PATH_POSFIXO)};
        return GroupedOpenApi.builder().group("Video").pathsToMatch(paths).build();
    }
}
