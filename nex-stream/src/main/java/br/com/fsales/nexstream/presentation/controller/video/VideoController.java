package br.com.fsales.nexstream.presentation.controller.video;

import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> uploadVideo(
            @ModelAttribute VideoRequest videoRequest
    ) {

        // Aqui você pode processar o arquivo e os outros atributos
        // Neste exemplo, apenas retornamos uma mensagem simples
        FilePart file = videoRequest.file();
        String titulo = videoRequest.titulo();
        String descricao = videoRequest.descricao();

        return DataBufferUtils.join(file.content())
                .map(dataBuffer -> {
                    // Processar o arquivo aqui (por exemplo, salvar no sistema de arquivos ou armazenar em um banco de dados)
                    // Neste exemplo, apenas retornamos uma mensagem simples
                    DataBufferUtils.release(dataBuffer);
                    return "Vídeo " + titulo + " enviado com sucesso!";
                });
    }
}
