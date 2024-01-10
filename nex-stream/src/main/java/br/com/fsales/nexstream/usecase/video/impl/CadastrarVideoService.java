package br.com.fsales.nexstream.usecase.video.impl;


import br.com.fsales.nexstream.dominio.RegraDeNegocioException;
import br.com.fsales.nexstream.dominio.core.video.model.Video;
import br.com.fsales.nexstream.dominio.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.DadosCadastrarVideo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
public class CadastrarVideoService implements CadastrarVideoUseCase {

    private final VideoRepository videoRepository;

    public CadastrarVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Mono<Video> execute(DadosCadastrarVideo dados) {
        return validarDados(dados)
                .then(Mono.defer(() -> {
                    Mono<Boolean> tituloCadastradoMono = videoRepository.tituloJaCadastrado(dados.titulo());
                    return tituloCadastradoMono != null ? tituloCadastradoMono : Mono.just(false);
                }))
                .flatMap(videoJaCadastrado -> {
                    if (videoJaCadastrado) {
                        return Mono.error(new RegraDeNegocioException("Cadastro não realizado: Título já cadastrado."));
                    }

                    var video = new Video(dados);
                    return videoRepository.cadastrar(video);
                })
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }


    private Mono<Void> validarDados(DadosCadastrarVideo dados) {
        if (dados.titulo() == null || dados.descricao() == null || dados.url() == null) {
            return Mono.error(new RegraDeNegocioException("Todos os campos do vídeo são obrigatórios."));
        }
        return Mono.empty();
    }

    private Mono<Video> criarErro(String mensagem) {
        log.error(mensagem);
        return Mono.error(new RegraDeNegocioException(mensagem));
    }
}
