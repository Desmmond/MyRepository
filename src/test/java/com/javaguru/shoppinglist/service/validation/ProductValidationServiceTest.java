package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    @Mock
    private ProductUniqueNameValidationRule uniqueNameValidationRule;

    @Mock
    private ProductNameValidationRule productNameValidationRule;

    @Captor
    private ArgumentCaptor<Product> captor;

    private ProductValidationService victim;

    private Product product = product();

    @Before
    public void setUp() {
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(uniqueNameValidationRule);
        rules.add(productNameValidationRule);

        victim = new ProductValidationService(rules);
    }

    @Test
    public void shouldValidate() {
        victim.validate(product);
        verify(uniqueNameValidationRule).validate(captor.capture());
        verify(productNameValidationRule).validate(captor.capture());

        List<Product> resultList = captor.getAllValues();
        assertThat(resultList).containsOnly(product);
    }

    private Product product() {
        Product product = new Product();
        product.setId(100L);
        product.setDescription("PRODUCT_DESCRIPTION");
        product.setName("PRODUCT_NAME");
        return product;
    }
}

