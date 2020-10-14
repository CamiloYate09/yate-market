package com.yate.market.persistence.mapper;


import com.yate.market.domain.Category;
import com.yate.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * En esta interfaz realizamos la conversion de los dos Objectos
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    /**
     * realizamos el prceso inverso del método anterior
     */


    @InheritInverseConfiguration
    @Mapping(target = "productos" , ignore = true)
    Categoria toCategoria(Category category);


}
