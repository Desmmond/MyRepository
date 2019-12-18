package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api/v1/products")
public class ProductController {

    private  ProductService productService;
    private ProductConverter productConverter;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }
    @PostMapping
    public ResponseEntity<Void> create(@Validated({ProductDto.Create.class}) @RequestBody ProductDto productDto,
                                       UriComponentsBuilder builder) {
        Long id = productService.createProduct(productConverter.convert(productDto));
        return ResponseEntity.created(builder.path("/products/{id").buildAndExpand(id).toUri()).build();

    }
    @PutMapping("/{id}/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return productConverter.convert(product);

    }
    @GetMapping (params = "name")
    public ProductDto findProductByName(@RequestParam("name") String name) {
        Product product = productService.findProductByName(name);
        return productConverter.convert(product);
    }

    @GetMapping
    public List<ProductDto> findAll() {

        return productService.FindAll().stream()
                .map(productConverter::convert).collect(Collectors.toList());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException(NoSuchElementException ex) {

    }

}

