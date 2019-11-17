package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price should not be null.");
        }

        if (product.getPrice().compareTo(BigDecimal.ZERO) != 1) {

            throw new ProductValidationException("Product price should be greater than 0.");

        }
    }
}

