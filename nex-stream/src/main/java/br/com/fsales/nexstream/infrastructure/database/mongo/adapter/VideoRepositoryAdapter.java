package br.com.fsales.nexstream.infrastructure.database.mongo.adapter;

import java.util.Objects;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import br.com.fsales.nexstream.domain.core.video.dto.DadosFiltroDto;
import br.com.fsales.nexstream.domain.core.video.model.Video;
import br.com.fsales.nexstream.domain.core.video.repository.VideoRepository;
import br.com.fsales.nexstream.infrastructure.database.mongo.mapper.VideoEntityMapper;
import br.com.fsales.nexstream.infrastructure.database.mongo.repository.VideoMongoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class VideoRepositoryAdapter implements VideoRepository {

    private final VideoMongoRepository repository;

    public Mono<Pagina<Video>> listarTodos(DadosFiltroDto filtro, int pageNumber, int pageSize) {

        return repository.consultaPaginada(filtro, pageNumber, pageSize);
    }

    @Override
    public Mono<Void> delete(String id) {

        if (StringUtils.isEmpty(id)) {
            return Mono.error(new IllegalArgumentException("ID do vídeo não pode ser nulo ou vazio."));
        }
        return repository.deleteById(id);
    }

    @Override
    public Mono<Video> cadastrar(Video video) {

        var videoEntity = VideoEntityMapper.convertToVideoEntity(video);

        var monoVideoEntity = repository.save(videoEntity);

        return monoVideoEntity.flatMap(savedVideoEntity -> Mono.just(VideoEntityMapper.convertToVideo(savedVideoEntity)));
    }

    @Override
    public Mono<Video> atualizar(Video video) {
        // Verifique se o objeto video tem um ID válido
        if (StringUtils.isEmpty(video.getId())) {
            return Mono.error(new IllegalArgumentException("ID do vídeo não pode ser nulo ou vazio para atualização."));
        }

        var videoEntity = VideoEntityMapper.convertToVideoEntity(video);

        // Utilize flatMap para lidar com a lógica após a operação de salvamento
        return repository.save(videoEntity)
                .flatMap(savedVideoEntity -> Mono.just(VideoEntityMapper.convertToVideo(savedVideoEntity)));
    }

    @Override
    public Mono<Video> detalhar(String id) {
        var monoVideoEntity = repository.findById(id);

        return monoVideoEntity.map(VideoEntityMapper::convertToVideo);
    }

    @Override
    public Mono<Boolean> tituloJaCadastrado(String titulo) {
        if (Objects.isNull(titulo) || StringUtils.isEmpty(titulo))
            return Mono.just(Boolean.FALSE);

        return repository.existsByTituloIgnoreCase(titulo);
    }

    @Override
    public Mono<Boolean> tituloJaCadastradoIgnorandoId(String titulo, String id) {
        if (Objects.isNull(titulo) || StringUtils.isEmpty(titulo))
            return Mono.just(Boolean.FALSE);

        return repository.existsByTituloIgnoreCaseAndIdNotIn(titulo, id);
    }
}
