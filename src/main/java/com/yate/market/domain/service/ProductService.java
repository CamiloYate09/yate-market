package com.yate.market.domain.service;


import com.yate.market.domain.Product;
import com.yate.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * esta clase es un intermediario entre el controlador y los datos
 *
 * Capa de Servicio
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productID) {
        return productRepository.getProduct(productID);

    }


    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public boolean delete(int productoId) {
        return getProduct(productoId).map(product -> {
            productRepository.delete(productoId);
            return true;
        }).orElse(false);
    }

}
