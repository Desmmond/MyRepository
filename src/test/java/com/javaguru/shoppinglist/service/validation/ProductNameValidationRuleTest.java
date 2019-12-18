package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.*;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.verify;

public class ProductNameValidationRuleTest {

    @Spy
    private ProductNameValidationRule victim;

    private Product input;

    @Test
    public void shouldThrowTaskValidationException() {
        input = product(null);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be not null.");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("valid name");

        victim.validate(input);

        verify(victim).checkNotNull(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }

}