package br.com.fsales.nexstream.presentation.rest.controller.video.swagger;


import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosFiltroVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosParaCadastrarVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.response.DadosVideoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

public interface VideoControllerSwagger {

    @Operation(summary = "Salvar um vídeo", tags = {"API de Video"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vídeo salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    Mono<ResponseEntity<DadosVideoResponse>> cadastrar(
            DadosParaCadastrarVideoRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    );

    @Operation(summary = "Atualiza um vídeo", tags = {"API de Video"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vídeo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    Mono<ResponseEntity<DadosVideoResponse>> atualizar(
            String id,
            DadosParaCadastrarVideoRequest requet
    );


    @Operation(summary = "Buscar todos os vídeos, opcional buscar por título, data de publicação ou categoria", tags = {"API de Video - GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vídeos encontrados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content)
    })
    @PageableAsQueryParam
    Mono<ResponseEntity<Page<DadosVideoResponse>>> listarTodos(
            DadosFiltroVideoRequest request,
            Pageable pageable
    );

    @Operation(summary = "Deletar vídeo por id", tags = {"API de Video"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vídeo deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição"),
            @ApiResponse(responseCode = "404", description = "Vídeo não encontrado"),
    })
    Mono<ResponseEntity<Void>> delete(
            String id
    );

    @Operation(summary = "Buscar vídeo por id", tags = {"API de Video - GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vídeo encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Algo de errado com a requisição", content = @Content),
            @ApiResponse(responseCode = "404", description = "Vídeo não encontrado", content = @Content),
    })
    Mono<ResponseEntity<DadosVideoResponse>> detalhar(
            String id
    );
}
