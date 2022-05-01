package com.example.Service;

import com.example.model.service.ProductServiceModel;
import com.example.model.view.ProductsViewModel;

import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    List<ProductsViewModel> findAllProducts();
}
