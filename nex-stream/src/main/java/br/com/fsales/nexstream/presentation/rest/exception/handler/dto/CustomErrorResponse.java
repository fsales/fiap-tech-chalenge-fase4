package br.com.fsales.nexstream.presentation.rest.exception.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorResponse {
    private OffsetDateTime timestamp;
    private HttpStatus status;
    private String traceId; // Adicione o traceId se estiver disponível
    private List<ErrorDetails> errors;
}