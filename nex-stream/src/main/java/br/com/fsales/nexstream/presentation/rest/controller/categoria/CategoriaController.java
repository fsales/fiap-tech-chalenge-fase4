package br.com.fsales.nexstream.presentation.rest.controller.categoria;

import br.com.fsales.nexstream.presentation.rest.controller.categoria.swagger.CategoriaControllerSwagger;
import br.com.fsales.nexstream.presentation.rest.dto.categoria.request.DadosParaCadastrarCategoriaRequest;
import br.com.fsales.nexstream.presentation.rest.dto.categoria.response.DadosCategoriaResponse;
import br.com.fsales.nexstream.presentation.rest.mapper.categoria.CategoriaDtoMapper;
import br.com.fsales.nexstream.presentation.rest.validation.groups.CreateInfo;
import br.com.fsales.nexstream.usecase.categoria.CadastrarCategoriaUseCase;
import br.com.fsales.nexstream.usecase.categoria.DetalharCategoriaPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/categorias")

@RequiredArgsConstructor
public class CategoriaController implements CategoriaControllerSwagger {

    private final CadastrarCategoriaUseCase categoriaUseCase;

    private final DetalharCategoriaPorIdUseCase detalharCategoriaPorIdUseCase;

    @PostMapping
    @Override
    public Mono<ResponseEntity<DadosCategoriaResponse>> cadastrar(
            @Validated(CreateInfo.class) @RequestBody DadosParaCadastrarCategoriaRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        var dadosParaCadastrarCategoriaPort = CategoriaDtoMapper
                .convertDadosParaCadastrarCategoriaRequestToDadosParaCadastrarCategoriaPort(requet);
        var mono = categoriaUseCase.execute(dadosParaCadastrarCategoriaPort);

        return mono.map(categoria -> {
            var categoriaResponse = CategoriaDtoMapper.convertCategoriaToDadosCategoriaResponse(categoria);
            var uri = uriComponentsBuilder
                    .path(String.format("%s/{id}", "/categorias"))
                    .buildAndExpand(categoriaResponse.id())
                    .toUri();

            return ResponseEntity.created(uri).body(categoriaResponse);
        });
    }

    @GetMapping("/{id}")
    @Override
    public Mono<ResponseEntity<DadosCategoriaResponse>> detalhar(@PathVariable String id) {
        var mono = detalharCategoriaPorIdUseCase.execute(id);
        return mono.map(categoria -> ResponseEntity.ok(CategoriaDtoMapper.convertCategoriaToDadosCategoriaResponse(categoria)));
    }


}
