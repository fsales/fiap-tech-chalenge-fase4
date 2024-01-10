package br.com.fsales.nexstream.presentation.rest.controller.video;

import br.com.fsales.nexstream.presentation.rest.controller.video.swagger.VideoControllerSwagger;
import br.com.fsales.nexstream.usecase.validation.groups.CreateInfo;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.dto.DadosParaCadastrarVideoDtoPort;
import br.com.fsales.nexstream.usecase.video.dto.DadosParaCadastrarVideoRequest;
import br.com.fsales.nexstream.usecase.video.dto.DadosVideoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")

@RequiredArgsConstructor
public class VideoController implements VideoControllerSwagger {

    private final CadastrarVideoUseCase service;

    @PostMapping
    @Override
    public Mono<ResponseEntity<DadosVideoResponse>> cadastrar(
            @Validated(CreateInfo.class) @RequestBody DadosParaCadastrarVideoRequest requet,
            UriComponentsBuilder uriComponentsBuilder
    ) {

        var dadosParaCadastrarVideoPort = new DadosParaCadastrarVideoDtoPort(requet);
        var mono = service.execute(dadosParaCadastrarVideoPort);

        return mono.map(item -> {

            var uri = uriComponentsBuilder.path(String.format("%s/{id}", "/videos"))
                    .buildAndExpand(item.id())
                    .toUri();
            return ResponseEntity.created(uri).body(item);
        });
    }

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Mono<String> uploadVideo(
//            @ModelAttribute VideoRequest videoRequest
//    ) {
//
//        // Aqui você pode processar o arquivo e os outros atributos
//        // Neste exemplo, apenas retornamos uma mensagem simples
//        FilePart file = videoRequest.file();
//        String titulo = videoRequest.titulo();
//        String descricao = videoRequest.descricao();
//
//        return DataBufferUtils.join(file.content())
//                .map(dataBuffer -> {
//                    // Processar o arquivo aqui (por exemplo, salvar no sistema de arquivos ou armazenar em um banco de dados)
//                    // Neste exemplo, apenas retornamos uma mensagem simples
//                    DataBufferUtils.release(dataBuffer);
//                    return "Vídeo " + titulo + " enviado com sucesso!";
//                });
//    }
}
