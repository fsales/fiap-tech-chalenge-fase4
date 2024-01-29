package br.com.fsales.nexstream.usecase.video.impl;

import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.domain.core.categoria.repository.CategoriaRepository;
import br.com.fsales.nexstream.domain.core.video.dto.DadosCadastrarVideoDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.usecase.video.AtualizarVideoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AtualizarVideoService implements AtualizarVideoUseCase {
    private final VideoRepository videoRepository;

    private final CategoriaRepository categoriaRepository;

    public AtualizarVideoService(VideoRepository videoRepository, CategoriaRepository categoriaRepository) {
        this.videoRepository = videoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Mono<Video> execute(String id, DadosCadastrarVideoDto dados) {
        return validarDados(dados)
                .then(Mono.defer(() -> {
                    Mono<Boolean> tituloCadastradoMono = videoRepository.tituloJaCadastradoIgnorandoId(dados.titulo(), id);
                    return tituloCadastradoMono != null ? tituloCadastradoMono : Mono.just(false);
                }))
                .flatMap(videoJaCadastrado -> {
                    if (videoJaCadastrado) {
                        return Mono.error(new RegraDeNegocioException("Atualização não realizada: Título já cadastrado."));
                    }
                    return categoriaRepository.detalharPorTitulo(dados.categoria());
                }).flatMap(categoria -> videoRepository.detalhar(id)
                        .switchIfEmpty(Mono.error(new RegraDeNegocioException("Vídeo não encontrado!")))
                        .flatMap(existingVideo -> {
                            // Atualizar os dados do vídeo existente com os novos dados
                            existingVideo.atualizarDados(dados, categoria);
                            // Agora, realizar a atualização no repositório
                            return videoRepository.atualizar(existingVideo);
                        })
                )
                .onErrorResume(RegraDeNegocioException.class, Mono::error);
    }


    private Mono<Void> validarDados(DadosCadastrarVideoDto dados) {
        if (StringUtils.isEmpty(dados.titulo()) || StringUtils.isEmpty(dados.descricao()) || StringUtils.isEmpty(dados.url()) || StringUtils.isEmpty(dados.categoria())) {
            return Mono.error(new RegraDeNegocioException("Todos os campos do vídeo são obrigatórios."));
        }
        return Mono.empty();
    }
}
