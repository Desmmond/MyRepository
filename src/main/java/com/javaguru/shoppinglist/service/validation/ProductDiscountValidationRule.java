package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {
    private static final BigDecimal MIN_PRICE_FOR_DISCOUNT = new BigDecimal("20");
    private static final BigDecimal MAX_DISCOUNT = new BigDecimal("100");

    @Override
    public void validate(Product product) {

        checkNotNull(product);
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount must be not null.");
        }
        if (product.getDiscount().doubleValue() > MAX_DISCOUNT.intValue()) {
            throw new ProductValidationException("The discount should not be more than " + MAX_DISCOUNT + " % ");
        }
        if (product.getDiscount().doubleValue() < 0) {
            throw new ProductValidationException("The discount cannot be less than 0.");
        }
        if (product.getPrice().intValue() < MIN_PRICE_FOR_DISCOUNT.intValue() && product.getDiscount().doubleValue() != BigDecimal.ZERO.intValue()) {
            throw new ProductValidationException("If the price of the product is less than " + MIN_PRICE_FOR_DISCOUNT +" then a discount cannot be made.");
        }
    }
}
