package com.example.battleships.model.binding;

import com.example.battleships.model.entity.CategoryName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ShipAddBindingModel {

    private String name;
    private Integer power;
    private Integer health;
    private String createdDate;
    private CategoryName categoryName;


    public ShipAddBindingModel() {
    }

    @Length(min = 2,message = "Name must be between 2 and 10 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Positive
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
    @Positive
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
    @NotNull(message = "Created date cannot be in the future.")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    @NotNull(message = "Enter valid category")
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }
}
