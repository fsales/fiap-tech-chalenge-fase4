package br.com.fsales.nexstream.infrastructure.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    //https://tjf.totvs.com.br/docs/archunit
    private final SwaggerConfigProperties swaggerConfigProperties;

    public SwaggerConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        var application = swaggerConfigProperties.getApplication();

        Schema<String> schema = new Schema<>();
        schema.addEnumItemObject("consumer1");
        schema.addEnumItemObject("swagger");
        schema.addEnumItemObject("consumer3");
        schema.setDefault("swagger");

        return new OpenAPI()
                .components(
                        new Components()
                                .addParameters(
                                        "myConsumerTypeHeader",
                                        new HeaderParameter()
                                                .required(true)
                                                .name("My-Consumer-Type")
                                                .description("The II Consumer Type")
                                                .schema(schema)
                                )
                )
                .info(
                        new Info()
                                .title(
                                        application.name()
                                )
                                .version(
                                        application.version()
                                )
                                .description(
                                        application.description()
                                )
                );
    }
}