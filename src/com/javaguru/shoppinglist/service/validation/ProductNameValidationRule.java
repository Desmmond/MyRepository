package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 32;

    @Override
    public void validate(Product product) {

        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        }

        if (product.getName().length() <= MIN_LENGTH || product.getName().length() >= MAX_LENGTH) {
            throw new ProductValidationException("Name cannot be less than 3 characters and more than 32. Please try again|");
        }

    }


}

