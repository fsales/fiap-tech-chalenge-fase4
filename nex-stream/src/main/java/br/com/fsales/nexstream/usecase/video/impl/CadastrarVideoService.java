package br.com.fsales.nexstream.usecase.video.impl;


import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.categoria.repository.CategoriaRepository;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.CadastrarVideoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class CadastrarVideoService implements CadastrarVideoUseCase {

    private final VideoRepository videoRepository;

    private final CategoriaRepository categoriaRepository;

    public CadastrarVideoService(VideoRepository videoRepository, CategoriaRepository categoriaRepository) {
        this.videoRepository = videoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Mono<Video> execute(DadosCadastrarVideoDto dados) {

        // consultar a categoria


        return validarDados(dados)
                .then(Mono.defer(() -> {
                    Mono<Boolean> tituloCadastradoMono = videoRepository.tituloJaCadastrado(dados.titulo());
                    return tituloCadastradoMono != null ? tituloCadastradoMono : Mono.just(false);
                }))
                .flatMap(videoJaCadastrado -> {
                    if (videoJaCadastrado) {
                        return Mono.error(new RegraDeNegocioException("Cadastro não realizado: Título já cadastrado."));
                    }
                    return categoriaRepository.detalharPorTitulo(dados.categoria());
                }).flatMap(categoria -> {
                    var video = new Video(dados, categoria);
                    return videoRepository.cadastrar(video);
                })
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }


    private Mono<Void> validarDados(DadosCadastrarVideoDto dados) {
        if (dados.titulo() == null || dados.descricao() == null || dados.url() == null) {
            return Mono.error(new RegraDeNegocioException("Todos os campos do vídeo são obrigatórios."));
        }
        return Mono.empty();
    }
}
