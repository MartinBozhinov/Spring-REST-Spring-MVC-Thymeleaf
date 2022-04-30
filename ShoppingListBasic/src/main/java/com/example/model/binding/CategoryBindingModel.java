package com.example.model.binding;

import com.example.model.entity.CategoryName;

public class CategoryBindingModel {

    private CategoryName name;
    private String description;

    public CategoryBindingModel() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
