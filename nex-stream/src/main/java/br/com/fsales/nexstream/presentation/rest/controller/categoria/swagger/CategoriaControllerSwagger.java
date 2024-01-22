package br.com.fsales.nexstream.presentation.rest.controller.categoria.swagger;

import br.com.fsales.nexstream.presentation.rest.dto.categoria.request.DadosParaCadastrarCategoriaRequest;
import br.com.fsales.nexstream.presentation.rest.dto.categoria.response.DadosCategoriaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

public interface CategoriaControllerSwagger {

    @Operation(summary = "Salvar uma categoria", tags = {"Categoria"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    Mono<ResponseEntity<DadosCategoriaResponse>> cadastrar(
            DadosParaCadastrarCategoriaRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    );

    @Operation(summary = "Buscar categoria por id", tags = {"Categoria"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrado", content = @Content),
    })
    Mono<ResponseEntity<DadosCategoriaResponse>> detalhar(String id);

}
