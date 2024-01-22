package br.com.fsales.nexstream.presentation.rest.controller.video.swagger;


import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosParaCadastrarVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.response.DadosVideoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

public interface VideoControllerSwagger {

    @Operation(summary = "Salvar um vídeo", tags = {"Video"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vídeo salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    Mono<ResponseEntity<DadosVideoResponse>> cadastrar(
            DadosParaCadastrarVideoRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    );
}
