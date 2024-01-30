package br.com.fsales.nexstream.presentation.rest.exception.handler.dto;

import br.com.fsales.nexstream.presentation.rest.exception.handler.dto.serializacao.ErrorDetailsSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonSerialize(using = ErrorDetailsSerializer.class)
public enum ErrorDetails {
    API_GENERIC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "about:blank");

    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("referenceUrl")
    private String referenceUrl;
    @JsonProperty("errorMessage")
    private String errorMessage;

    ErrorDetails(Integer errorCode, String errorMessage, String referenceUrl) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.referenceUrl = referenceUrl;
    }

    // Método para atualizar a errorCode
    public ErrorDetails updateErrorCode(Integer newErrorCode) {
        this.errorCode = newErrorCode;
        return this;
    }

    // Método para atualizar a referenceUrl
    public ErrorDetails updateUri(String newReferenceUrl) {
        this.referenceUrl = newReferenceUrl;
        return this;
    }

    // Método para atualizar a errorMessage
    public ErrorDetails updateErrorMessage(String newErrorMessage) {
        this.errorMessage = newErrorMessage;
        return this;
    }
}