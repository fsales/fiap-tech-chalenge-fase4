package br.com.fsales.nexstream.presentation.rest.exception.handler.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorDetails {
    API_GENERIC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "about:blank");

    private final Integer errorCode;
    private final String errorMessage;
    private final String referenceUrl;
    private String uri;

    ErrorDetails(Integer errorCode, String errorMessage, String referenceUrl) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.referenceUrl = referenceUrl;
        this.uri = referenceUrl;
    }

    // Método para atualizar a URI
    public ErrorDetails updateUri(String newUri) {
        this.uri = newUri;
        return this;
    }
}