package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    void update(Product product);

    Optional<Product> findProductById(Long id);

    boolean existsByName(String name);

    Optional<Product> findProductByName(String name);
}

