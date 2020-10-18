package com.yate.market.persistence.crud;

import com.yate.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /**
     * Una forma de hacer una consulta
     * es mejor y recomendado esta forma
     *
     * @param idProducto
     * @return
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idProducto);


//    /**
//     * Segunda forma de hacerlo con query nativo sql
//     *
//     * @param idCategoria
//     * @return
//     */
//    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
//    List<Producto> getIdCategoria(int idCategoria);


    Optional<List<Producto>> findByCantidadStockIsLessThanAndEstado(int cantidadStock, boolean estado);
}
