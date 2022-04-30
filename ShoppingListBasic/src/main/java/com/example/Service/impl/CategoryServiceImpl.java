package com.example.Service.impl;

import com.example.Repository.CategoryRepository;
import com.example.Service.CategoryService;
import com.example.model.entity.Category;
import com.example.model.entity.CategoryName;
import com.example.model.service.CategoryServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName,String.format
                                        ("Description: %s",categoryName.name())));

                    });
        }
    }

    @Override
    public CategoryServiceModel findByName(CategoryName categoryName) {
        return this.categoryRepository.findByName(categoryName)
                .map(category -> this.modelMapper.map(category, CategoryServiceModel.class))
                .orElse(null);

    }


}
