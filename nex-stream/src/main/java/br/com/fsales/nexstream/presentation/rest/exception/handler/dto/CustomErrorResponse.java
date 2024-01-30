package br.com.fsales.nexstream.presentation.rest.exception.handler.dto;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorResponse {
    private OffsetDateTime timestamp;
    private HttpStatus status;
    private String traceId;
    private List<ErrorDetails> errors;
}