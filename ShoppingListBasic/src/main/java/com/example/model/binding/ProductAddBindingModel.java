package com.example.model.binding;

import com.example.model.entity.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private String neededBefore;
    private BigDecimal price;
    private CategoryBindingModel category;

    public ProductAddBindingModel() {
    }


    @Length(min = 3, message = "Name length must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Length(min = 5, message = "Description min length must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @DecimalMin(value = "0",message = "The price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(String neededBefore) {
        this.neededBefore = neededBefore;
    }
    @NotNull(message = "Category cannot be null")
    public CategoryBindingModel getCategory() {
        return category;
    }

    public void setCategory(CategoryBindingModel category) {
        this.category = category;
    }
}
