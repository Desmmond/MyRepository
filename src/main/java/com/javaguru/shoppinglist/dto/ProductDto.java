package com.javaguru.shoppinglist.dto;





import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    @NotNull(groups = {Update.class})
    @Null(groups = {Create.class})
    private Long id;
    @NotEmpty(groups = {Update.class, Create.class}, message = "Name must not be blank.")
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String category;
    private String description;

    public ProductDto() {

    }

    public ProductDto(Long id, String name, BigDecimal price, BigDecimal discount, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(category, that.category) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, discount, category, description);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public interface Update {

    }

    public interface Create {

    }
}
