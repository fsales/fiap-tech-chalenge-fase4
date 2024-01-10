package br.com.fsales.nexstream.presentation.rest.controller.video;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.dto.DadosParaCadastrarVideoDto;
import br.com.fsales.nexstream.usecase.video.dto.DadosParaCadastrarVideoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")

@RequiredArgsConstructor
public class VideoController {

    private final CadastrarVideoUseCase service;

    @PostMapping
    public Mono<Video> save(@RequestBody DadosParaCadastrarVideoDto requet) {

        var dadosParaCadastrarVideoPort = new DadosParaCadastrarVideoPort(requet);

        return service.execute(dadosParaCadastrarVideoPort);
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
