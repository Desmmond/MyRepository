package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;


public class ProductPriceValidationRuleTest {

    private ProductPriceValidationRule victim;

    @Before
    public void setUp() {
         victim = new ProductPriceValidationRule();

    }
    @Test
    public void shouldThrowException(){
        Product input = product();
        input.setPrice(null);
        assertThatThrownBy(()->victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Product price should not be null.");
    }
    @Test
    public void shouldThrowPriceRuleException() {
        Product input = product();
        input.setPrice(new BigDecimal("-1"));
        assertThatThrownBy(()->victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Product price should be greater than 0.");
    }

    @Test
    public void validate() {
        victim.validate(product());
    }

    private Product product() {
        Product product = new Product();
        product.setPrice(new BigDecimal("20"));
        return product;
    }
}