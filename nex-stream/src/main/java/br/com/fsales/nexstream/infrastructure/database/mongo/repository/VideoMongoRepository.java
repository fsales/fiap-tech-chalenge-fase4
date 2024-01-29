package br.com.fsales.nexstream.infrastructure.database.mongo.repository;

import java.awt.print.Pageable;

import br.com.fsales.nexstream.infrastructure.database.mongo.entity.VideoEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VideoMongoRepository extends ReactiveMongoRepository<VideoEntity, String>, VideoMongoRepositoryCustom<VideoEntity> {

    Mono<Boolean> existsByTituloIgnoreCase(String titulo);

    Mono<Boolean> existsByTituloIgnoreCaseAndIdNotIn(String titulo, String id);

//    @Query("{}")
//    Flux<VideoEntity> findAllPaginated(Pageable pageable);
}
