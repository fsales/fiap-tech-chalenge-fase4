package br.com.fsales.nexstream.infrastructure.database.mongo.repository;

import br.com.fsales.nexstream.infrastructure.database.mongo.entity.CategoriaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoriaMongoRepository extends ReactiveMongoRepository<CategoriaEntity, String> {

    Mono<Boolean> existsByTituloIgnoreCase(String titulo);
}
