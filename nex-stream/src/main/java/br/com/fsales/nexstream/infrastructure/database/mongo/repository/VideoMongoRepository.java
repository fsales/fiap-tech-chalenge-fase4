package br.com.fsales.nexstream.infrastructure.database.mongo.repository;

import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VideoMongoRepository extends ReactiveMongoRepository<VideoEntity, String> {

    Mono<Boolean> existsByTituloIgnoreCase(String titulo);

    Mono<Boolean> existsByTituloIgnoreCaseAndIdNotIn(String titulo, String id);
}
