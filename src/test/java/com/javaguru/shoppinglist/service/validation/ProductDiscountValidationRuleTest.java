package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {

    private static final BigDecimal MIN_PRICE_FOR_DISCOUNT = new BigDecimal("20");

    private static final BigDecimal MAX_DISCOUNT = new BigDecimal("100");

    private ProductDiscountValidationRule victim;

    private Product product = product();

    @Before
    public void setUp() {
        victim = new ProductDiscountValidationRule();
    }

    @Test
    public void shouldThrowException() {
        assertThatThrownBy(()-> victim.checkNotNull(null)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Product must be not null");
    }
    @Test
    public void shouldThrowNullException() {
        Product input = product();
        input.setDiscount(null);
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Product discount must be not null.");

    }
    @Test
    public void shouldThrowMaxDiscountException() {
        Product input = product();
        input.setDiscount(new BigDecimal("101"));
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The discount should not be more than " + MAX_DISCOUNT + " % ");
    }
    @Test
    public void shouldThrowLessDiscountException() {
        Product input = product();
        input.setDiscount(new BigDecimal("-2"));
        assertThatThrownBy(()-> victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The discount cannot be less than 0.");

    }
    @Test
    public void shouldThrowMinPriceForDiscountException() {
        Product input = product();
        input.setDiscount(new BigDecimal("10"));
        input.setPrice(new BigDecimal("19"));
        assertThatThrownBy(()->victim.validate(input)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("If the price of the product is less than " + MIN_PRICE_FOR_DISCOUNT +" then a discount cannot be made.");

    }
    @Test
    public void validation() {
        victim.validate(product());
    }

    private Product product(){
        Product product = new Product();
        product.setName("Test");
        product.setPrice(new BigDecimal("50"));
        product.setDiscount(new BigDecimal("0"));
        product.setCategory("bla");
        product.setDescription("This is test product");
        return product;
    }
}

