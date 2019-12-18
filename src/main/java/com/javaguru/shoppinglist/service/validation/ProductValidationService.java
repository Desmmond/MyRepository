package com.javaguru.shoppinglist.service.validation;


import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;


    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(final Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

}

