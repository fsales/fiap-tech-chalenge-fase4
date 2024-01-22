package br.com.fsales.nexstream.infrastructure.database.mongo.mapper;

import br.com.fsales.nexstream.domain.core.categoria.dto.DadosCadastroCategoriaDto;
import br.com.fsales.nexstream.domain.core.categoria.model.Categoria;
import br.com.fsales.nexstream.infrastructure.database.mongo.entity.CategoriaEntity;

public final class CategoriaEntityMapper {

    private CategoriaEntityMapper() {
    }

    public static Categoria convertToCategoria(CategoriaEntity categoriaEntity) {

        return new Categoria(new DadosCadastroCategoriaDto() {

            @Override
            public String titulo() {
                return categoriaEntity.getTitulo();
            }

            @Override
            public String id() {
                return categoriaEntity.getId();
            }
        });
    }

    public static CategoriaEntity convertToCategoriaEntity(Categoria categoria) {

        return new CategoriaEntity(
                categoria.getTitulo()
        );
    }

}
