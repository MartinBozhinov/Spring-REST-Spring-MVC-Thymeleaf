package com.example.web;

import com.example.Service.ProductService;
import com.example.model.binding.ProductAddBindingModel;
import com.example.model.service.ProductServiceModel;
import com.example.model.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductsController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String product(){
        return "product-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("productAddBindingModel")
                                         ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return  "redirect:add";
        }


        this.productService.addProduct(this.modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:add";
    }
}
