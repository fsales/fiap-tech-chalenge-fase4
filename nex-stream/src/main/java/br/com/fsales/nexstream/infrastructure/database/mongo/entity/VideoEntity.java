package br.com.fsales.nexstream.infrastructure.database.mongo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
@CompoundIndexes({
        @CompoundIndex(name = "idx_titulo", def = "{'titulo': 1}"),
        @CompoundIndex(name = "idx_dataPublicacao", def = "{'dataPublicacao': 1}")})

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
public class VideoEntity {

    @Id
    private String id;

    @NotBlank(message = "Título do vídeo é obrigatório.")
    @Size(max = 100, message = "Título deve ter no máximo {max} caracteres.")
    private String titulo;

    @NotBlank(message = "Descrição do vídeo é obrigatório.")
    @Size(max = 255, message = "Descrição deve ter no máximo {max} caracteres.")
    private String descricao;

    @NotBlank(message = "URL do vídeo é obrigatório.")
    @Size(max = 255, message = "url deve ter no máximo {max} caracteres.")
    @URL(message = "url inválida")
    private String url;

    @NotBlank(message = "Data de Publicação do vídeo é obrigatório.")
    @FutureOrPresent
    private LocalDate dataPublicacao;

    @NotNull(message = "Categoria do vídeo é obrigatório.")
    private CategoriaEntity categoria;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public VideoEntity(String titulo, String descricao, String url, LocalDate dataPublicacao, CategoriaEntity categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;

    }
}