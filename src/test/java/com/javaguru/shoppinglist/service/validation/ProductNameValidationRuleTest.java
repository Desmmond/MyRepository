package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 32;

    private ProductNameValidationRule victim;

    @Before
    public void setUp() {
        victim = new ProductNameValidationRule();
    }

    @Test
    public void shouldThrowException() {
        Product input = product();
        input.setName(null);
        assertThatThrownBy(()->victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Product name must be not null.");

    }
    @Test
    public void shouldTrowMinLengthNameException() {
        Product input = product();
        input.setName("Hi");
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Name cannot be less than 3 characters and more than 32. Please try again|");
    }
    @Test
    public void shouldTrowMaxLengthNameException() {
        Product input = product();
        input.setName("SehensvurdikaitenInDeultchlandIstserhVunderbar_DasIsDieEndeDIeMessege");
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Name cannot be less than 3 characters and more than 32. Please try again|");

    }

    @Test
    public void validate() {
        victim.validate(product());
    }

    private Product product() {
        Product product = new Product();
        product.setName("Test");
        return product;
    }
}