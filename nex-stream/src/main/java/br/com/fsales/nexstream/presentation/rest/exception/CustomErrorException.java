package br.com.fsales.nexstream.presentation.rest.exception;

import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.CustomErrorResponse;
import lombok.Getter;


@Getter
public class CustomErrorException extends RuntimeException {

    private final CustomErrorResponse errorResponse;

    public CustomErrorException(String message, CustomErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }
}
