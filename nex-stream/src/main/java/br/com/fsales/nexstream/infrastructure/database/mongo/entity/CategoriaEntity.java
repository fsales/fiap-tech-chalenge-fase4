package br.com.fsales.nexstream.infrastructure.database.mongo.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
@CompoundIndexes({
        @CompoundIndex(name = "idx_titulo", def = "{'titulo': 1}")
})

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
public class CategoriaEntity {

    @Id
    private String id;

    @NotBlank(message = "Título da categoria é obrigatório.")
    @Size(max = 100, message = "Título deve ter no máximo {max} caracteres.")
    private String titulo;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public CategoriaEntity(String titulo) {
        this.titulo = titulo;
    }

}