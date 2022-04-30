package com.example.Service;

import com.example.model.entity.Category;
import com.example.model.entity.CategoryName;
import com.example.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();


    CategoryServiceModel findByName(CategoryName categoryName);
}
