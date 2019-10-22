package com.javaguru.shoppinglist.service.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.extractProperty;


public class ProductInMemoryRepositoryTest {

    private static final String PRODUCT_NAME = "TEST_NAME";
    private static final String PRODUCT_DESCRIPTION = "TEST_DESCRIPTION";
    private static final long PRODUCT_ID = 0L;

    private ProductInMemoryRepository victim = new ProductInMemoryRepository();

    private Product product = product();

    @Test
    public void shouldInsert() {
        Product result = victim.save(product);

        assertThat(result).isEqualTo(expectedProduct());
    }

    @Test
    public void shouldFindById() {
        victim.save(product);

        Optional<Product> result = victim.findProductById(PRODUCT_ID);
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());
    }

    @Test
    public void shouldFindByName() {
        victim.save(product);

        Optional<Product> result = victim.findProductByName(PRODUCT_NAME);
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());
    }

    @Test
    public void shouldExistByName() {
        victim.save(product);

        boolean result = victim.existsByName(PRODUCT_NAME);
        assertThat(result).isTrue();
    }

    private Product expectedProduct() {
        Product product = new Product();
        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setId(PRODUCT_ID);
        return product;
    }

    private Product product() {
        Product product = new Product();
        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }
}