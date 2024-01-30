package br.com.fsales.nexstream.infrastructure.database.mongo.repository;

import java.util.List;

import br.com.fsales.nexstream.domain.core.page.Pagina;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Mono;

public interface PageRepositoryCustom<T> {
    int LIMIT = -1;

    int SKIP = -1;

    default Mono<Pagina<T>> consultaDocumentosPaginado(
            Query query,
            ReactiveMongoTemplate reactiveMongoTemplate,
            Class<T> entityClass,
            Pageable pageable,
            Sort sort
    ) {

        query.with(pageable)
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize()).with(sort);

        // Realizar a consulta paginada
        Mono<List<T>> resultListMono = reactiveMongoTemplate.find(query, entityClass)
                .collectList();

        // Realizar a contagem total
        Mono<Long> totalElementsMono = reactiveMongoTemplate.count(query.skip(SKIP).limit(LIMIT), entityClass);

        // Combinar resultados usando flatMap
        return resultListMono.flatMap(resultList ->
                totalElementsMono.map(totalElements -> new Pagina<>(resultList, totalElements))
        );
    }
}
