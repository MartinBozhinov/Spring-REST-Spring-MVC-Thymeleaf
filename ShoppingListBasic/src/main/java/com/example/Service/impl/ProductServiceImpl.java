package com.example.Service.impl;

import com.example.Repository.ProductRepository;
import com.example.Service.CategoryService;
import com.example.Service.ProductService;
import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.model.service.CategoryServiceModel;
import com.example.model.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        CategoryServiceModel categoryServiceModel =
                this.categoryService.findByName(productServiceModel.getCategory().getName());

        productServiceModel.setCategory(this.modelMapper.map(categoryServiceModel, Category.class));

        this.productRepository.saveAndFlush(this.modelMapper.map(productServiceModel, Product.class));
        

    }
}
