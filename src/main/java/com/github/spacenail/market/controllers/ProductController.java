package com.github.spacenail.market.controllers;

import com.github.spacenail.market.service.Product;
import com.github.spacenail.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @GetMapping("/product")
    public String product(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
