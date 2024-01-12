package br.com.fsales.nexstream.presentation.rest.exception.handler;


import br.com.fsales.nexstream.domain.RegraDeNegocioException;
import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.CustomErrorResponse;
import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.ErrorDetails;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * https://www.baeldung.com/spring-boot-custom-webflux-exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected Mono<ResponseEntity<Object>> handleGenericException(Exception ex, ServerWebExchange exchange) {
        return handleExceptionInternal(ex, buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), exchange), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, exchange);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Mono<ResponseEntity<Object>> handleRegraDeNegocioException(RegraDeNegocioException ex, ServerWebExchange exchange) {
        return handleExceptionInternal(ex, buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), exchange), new HttpHeaders(), HttpStatus.BAD_REQUEST, exchange);
    }

    @ExceptionHandler({ConstraintViolationException.class, MongoWriteException.class, MongoException.class, DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Mono<ResponseEntity<Object>> handleBadRequestException(Exception ex, ServerWebExchange exchange) {
        return handleExceptionInternal(ex, buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), exchange), new HttpHeaders(), HttpStatus.BAD_REQUEST, exchange);
    }

    private CustomErrorResponse buildErrorResponse(HttpStatus status, String message, ServerWebExchange exchange) {
        var uri = extractUri(exchange);

        return CustomErrorResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(status)
                .errors(
                        Collections.singletonList(
                                ErrorDetails.API_GENERIC_ERROR
                                        .updateErrorCode(status.value())
                                        .updateUri(uri.getPath())
                                        .updateErrorMessage(message)
                        )
                )
                .build();
    }

    private URI extractUri(ServerWebExchange exchange) {
        return Optional.of(exchange.getRequest().getURI())
                .map(URI::toString)
                .map(URI::create)
                .orElse(URI.create("about:blank"));
    }
}
