package com.example.pathfinder_app.entity;

import com.example.pathfinder_app.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{


    private CategoryName name;
    private String description;

    public Category() {
    }
    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName categoryName) {
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
