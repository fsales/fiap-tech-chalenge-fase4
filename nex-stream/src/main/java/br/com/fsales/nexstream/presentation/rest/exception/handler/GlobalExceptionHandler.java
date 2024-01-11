package br.com.fsales.nexstream.presentation.rest.exception.handler;


import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.CustomErrorResponse;
import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.ErrorDetails;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected Mono<ResponseEntity<Object>> handleGenericException(Exception ex, ServerWebExchange exchange) {
        var uri = extractUri(exchange);

        CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errors(Collections.singletonList(ErrorDetails.API_GENERIC_ERROR.updateUri(uri.getPath())))
                .build();
// https://www.baeldung.com/spring-boot-custom-webflux-exceptions
        return handleExceptionInternal(ex, customErrorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, exchange);
    }

    private URI extractUri(ServerWebExchange exchange) {
        return Optional.of(exchange.getRequest().getURI())
                .map(URI::toString)
                .map(URI::create)
                .orElse(URI.create("about:blank"));
    }
}
