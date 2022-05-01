package com.example.battleships.init;

import com.example.battleships.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
        private final CategoryService categoryService;
        private final ModelMapper modelMapper;

    public DataInit(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void run(String... args) throws Exception {
         this.categoryService.initCategories();
    }
}
