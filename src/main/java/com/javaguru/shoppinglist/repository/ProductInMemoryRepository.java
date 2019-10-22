package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product save(Product product) {
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public boolean existsByName(String name) {
        return products.values().stream()
                .anyMatch(task -> task.getName().equalsIgnoreCase(name));
    }

    public Optional<Product> findProductByName(String name) {
        return products.values().stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
