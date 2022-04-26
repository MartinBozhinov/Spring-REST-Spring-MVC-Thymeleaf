package com.example.model.entity;

import com.example.model.entity.BaseEntity;
import com.example.model.entity.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryName name;
    private String description;

    public Category() {
    }

    public Category(CategoryName name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    public CategoryName getName() {
        return name;
    }
    public void setName(CategoryName name) {
        this.name = name;
    }
    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
