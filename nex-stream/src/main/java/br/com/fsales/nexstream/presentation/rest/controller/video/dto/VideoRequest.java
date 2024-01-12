package br.com.fsales.nexstream.presentation.rest.controller.video.dto;

import org.springframework.http.codec.multipart.FilePart;
public record VideoRequest(
        FilePart file,
        String titulo,
        String descricao
) {
}
