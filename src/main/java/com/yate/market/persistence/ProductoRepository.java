package com.yate.market.persistence;

import com.yate.market.domain.Product;
import com.yate.market.domain.repository.ProductRepository;
import com.yate.market.persistence.crud.ProductoCrudRepository;
import com.yate.market.persistence.entity.Producto;
import com.yate.market.persistence.mapper.ProductMapper;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */

/**
 * Esta clase esta interactuando con la base de datos por eso
 * se pone esta anotación Repository
 */
@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    /**
     * TODO verificar el error presente en el Autowired
     */
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();

        return productMapper.toProducts(productos);
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        /**
         * Primero recuperamos los datos de la base de datos
         */
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockIsLessThanAndEstado(quantity, Boolean.TRUE);
        /**
         * Utilizamos una expresión lambda
         */
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        /**
         * Expresión Lambda
         */
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
