package com.example.model.service;

import com.example.model.entity.Category;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel extends BaseServiceModel {

    private String name;
    private String description;
    private BigDecimal price;
    private String neededBefore;
    private Category category;

    public ProductServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
