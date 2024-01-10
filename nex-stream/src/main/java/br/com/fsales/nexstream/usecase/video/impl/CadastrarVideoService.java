package br.com.fsales.nexstream.usecase.video.impl;


import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import br.com.fsales.nexstream.usecase.video.dto.DadosVideoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class CadastrarVideoService implements CadastrarVideoUseCase {

    private final VideoRepository videoRepository;

    public CadastrarVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Mono<DadosVideoResponse> execute(DadosCadastrarVideoDto dados) {
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
                }).map(DadosVideoResponse::new)
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }


    private Mono<Void> validarDados(DadosCadastrarVideoDto dados) {
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
