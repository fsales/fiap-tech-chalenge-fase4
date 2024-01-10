package br.com.fsales.nexstream.infrastructure.database.mongo.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String url;

    @NotBlank
    private LocalDateTime dataPublicacao;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public VideoEntity(String titulo, String descricao, String url,LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataPublicacao = dataPublicacao;

    }
}