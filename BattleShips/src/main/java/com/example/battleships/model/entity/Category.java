package com.example.battleships.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryName name;
    private String description;

    public Category() {
    }

    public Category(CategoryName categoryName, String format) {
        this.name = categoryName;
        this.description = format;
    }

    @Enumerated(EnumType.ORDINAL)
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }
    @Column(name = "description",columnDefinition = "LONGTEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
