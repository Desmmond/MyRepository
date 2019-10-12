package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        checkNotNull(product);
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount must be not null.");
        }
        if (product.getDiscount().doubleValue() > 100) {
            throw new ProductValidationException("The discount should not be more than 100%.");
        }
        if (product.getDiscount().doubleValue() < 0) {
            throw new ProductValidationException("The discount cannot be less than 0.");
        }
        if (product.getPrice().intValue() < 20 && product.getDiscount().doubleValue() != 0) {
            throw new ProductValidationException("If the price of the product is less than $ 20, then a discount cannot be made.");
        }
    }
}
