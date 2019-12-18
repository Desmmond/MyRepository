package com.javaguru.shoppinglist.mapper;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDto productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDiscount(productDto.getDiscount());
        return product;

    }

    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setDiscount(product.getDiscount());
        return productDto;
    }
}
