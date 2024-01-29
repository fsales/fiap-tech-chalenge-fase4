package br.com.fsales.nexstream.infrastructure.database.mongo.repository;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Mono;

public interface PageRepositoryCustom<T> {

	default Mono<Pagina<T>> consultaDocumentosPaginado(Query query, ReactiveMongoTemplate mongoTemplate, Class<T> entityClass, Pageable pageable) {
		// Configurando a paginação diretamente no Query
		query.with(pageable);

		// Realizando a consulta com a paginação
		return mongoTemplate.find(query, entityClass)
				.collectList()
				.flatMap(resultList -> {
					Mono<Long> totalElements = mongoTemplate.count(query, entityClass);
					return totalElements.map(total -> new Pagina<>(resultList, total));
				});
	}
}
