package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductValidationService validationService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService,
                          ProductConverter productConverter) {
        this.repository = repository;
        this.validationService = validationService;
        this.productConverter = productConverter;
    }


    public Long createProduct(Product product) {
        validationService.validate(product);
        return repository.save(product);
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found, id: " + id));
    }

    public Product findProductByName(String name) {
        return repository.findProductByName(name)
                .orElseThrow(() -> new NoSuchElementException("Product not found, name: " + name));
    }

    public void updateProduct(Product product) {
                repository.update(product);

    }
    public List<Product> FindAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());

    }
    @Transactional
    public void deleteProduct(Long id) {
        repository.findProductById(id)
                .ifPresent(repository::delete);
    }
}
