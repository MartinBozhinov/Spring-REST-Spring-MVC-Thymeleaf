package com.example.battleships.service.impl;

import com.example.battleships.service.CategoryService;
import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.CategoryName;
import com.example.battleships.repository.CategoryRepository;
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
}
