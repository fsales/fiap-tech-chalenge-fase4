package br.com.fsales.nexstream.infrastructure.persistence.jpa.entity;

import java.time.LocalDateTime;

import br.com.fsales.nexstream.dominio.core.video.model.Video;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "videos")
@CompoundIndexes({
        @CompoundIndex(name = "idx_titulo", def = "{'titulo': 1}"),
        @CompoundIndex(name = "idx_dataPublicacao", def = "{'dataPublicacao': 1}")})

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class VideoEntity {

    @Id
    private String id;

    @NotBlank
    private String codigo;

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

    @Builder(builderMethodName = "entityBuilder", setterPrefix = "from")
    public VideoEntity(Video video) {
        this.codigo = video.getCodigo();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();
        this.dataPublicacao = video.getDataPublicacao();
    }
}
