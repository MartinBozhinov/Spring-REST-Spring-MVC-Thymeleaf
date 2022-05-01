package com.example.Service.impl;

import com.example.Repository.ProductRepository;
import com.example.Service.CategoryService;
import com.example.Service.ProductService;
import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.model.service.CategoryServiceModel;
import com.example.model.service.ProductServiceModel;
import com.example.model.view.ProductsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


        productServiceModel.setCategory(categoryServiceModel);

        this.productRepository.saveAndFlush(this.modelMapper.map(productServiceModel, Product.class));


    }

    @Override
    public List<ProductsViewModel> findAllProducts() {

        return this.productRepository.findAll()
                .stream()
                .map(product -> {
                    ProductsViewModel productsViewModel = this.modelMapper
                            .map(product,ProductsViewModel.class);
                    productsViewModel.setImgUrl
                            (String.format("/img/%s.png",productsViewModel.getCategoryName().name()));

                    return productsViewModel;
                }).collect(Collectors.toList());

    }
}
