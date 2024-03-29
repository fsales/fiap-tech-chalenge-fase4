package br.com.fsales.nexstream.presentation.rest.controller.video;

import br.com.fsales.nexstream.presentation.rest.controller.video.swagger.VideoControllerSwagger;
import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosFiltroVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.request.DadosParaCadastrarVideoRequest;
import br.com.fsales.nexstream.presentation.rest.dto.video.response.DadosVideoResponse;
import br.com.fsales.nexstream.presentation.rest.mapper.video.VideoDtoMapper;
import br.com.fsales.nexstream.presentation.rest.validation.groups.CreateInfo;
import br.com.fsales.nexstream.presentation.rest.validation.groups.UpdateInfo;
import br.com.fsales.nexstream.usecase.video.AtualizarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.ConsultarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.DeleteVideoUseCase;
import br.com.fsales.nexstream.usecase.video.DetalharVideoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")

@RequiredArgsConstructor
public class VideoController implements VideoControllerSwagger {

    private final CadastrarVideoUseCase cadastrarVideoUseCase;

    private final AtualizarVideoUseCase atualizarVideoUseCase;

    private final ConsultarVideoUseCase consultarVideoUseCase;

    private final DeleteVideoUseCase deleteVideoUseCase;

    private final DetalharVideoUseCase detalharVideoUseCase;

    @PostMapping
    @Override
    public Mono<ResponseEntity<DadosVideoResponse>> cadastrar(
            @Validated(CreateInfo.class) @RequestBody DadosParaCadastrarVideoRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    ) {


        var dadosParaCadastrarVideoPort = VideoDtoMapper.convertDadosParaCadastrarVideoRequestToDadosParaCadastrarVideoPort(requet);
        var mono = cadastrarVideoUseCase.execute(dadosParaCadastrarVideoPort);

        return mono.map(video -> {
            var videoResponse = VideoDtoMapper.convertVideoToDadosVideoResponse(video);
            var uri = uriComponentsBuilder.path(String.format("%s/{id}", "/videos"))
                    .buildAndExpand(videoResponse.id())
                    .toUri();
            return ResponseEntity.created(uri).body(videoResponse);
        });
    }


    @PutMapping("/{id}")
    @Override
    public Mono<ResponseEntity<DadosVideoResponse>> atualizar(
            @Validated(UpdateInfo.class)
            @PathVariable("id") String id,
            @RequestBody @Valid DadosParaCadastrarVideoRequest requet
    ) {

        var dadosParaAtualizarrVideoPort = VideoDtoMapper.convertDadosParaCadastrarVideoRequestToDadosParaCadastrarVideoPort(requet);
        var mono = atualizarVideoUseCase.execute(id, dadosParaAtualizarrVideoPort);

        return mono.map(video -> ResponseEntity.ok(VideoDtoMapper.convertVideoToDadosVideoResponse(video)));
    }

    @GetMapping
    @Override
    public Mono<ResponseEntity<Page<DadosVideoResponse>>> listarTodos(
            DadosFiltroVideoRequest request,
            @PageableDefault(sort = {"categoria.titulo"}) Pageable pageable
    ) {
        return consultarVideoUseCase
                .execute(
                        request,
                        pageable.getPageNumber(),
                        pageable.getPageSize()
                )
                .map(
                        pagina -> {
                            var page = pagina.map(VideoDtoMapper::convertVideoToDadosVideoResponse);
                            var total = page.totalElements();
                            var pageSize = pageable.getPageSize();
                            var pageNumber = pageable.getPageNumber();

                            return ResponseEntity.ok(new PageImpl<>(page.list(), PageRequest.of(pageNumber, pageSize), total));
                        }
                );
    }


    @DeleteMapping("/{id}")
    @Override
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable String id
    ) {
        return deleteVideoUseCase
                .execute(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @GetMapping("/{id}")
    @Override
    public Mono<ResponseEntity<DadosVideoResponse>> detalhar(
            @PathVariable(name = "id") String id
    ) {
        return detalharVideoUseCase
                .execute(id)
                .map(video -> ResponseEntity.ok(VideoDtoMapper.convertVideoToDadosVideoResponse(video)));
    }
}
