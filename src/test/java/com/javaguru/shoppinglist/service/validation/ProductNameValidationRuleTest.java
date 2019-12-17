package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.*;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.verify;

public class ProductNameValidationRuleTest {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 32;

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

    @Test
    public void shouldTrowMinLengthNameException() {
         input = product("Hi");
         assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Name cannot be less than " + MIN_LENGTH + " characters and more than "
                        + MAX_LENGTH + ". Please try again|");
    }
    @Test
    public void shouldTrowMaxLengthNameException() {
        input = product("CheckingForTheMaximumPermissibleLengthInTheNameForTheProduct");
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Name cannot be less than " + MIN_LENGTH + " characters and more than "
                        + MAX_LENGTH + ". Please try again|");

    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }

}