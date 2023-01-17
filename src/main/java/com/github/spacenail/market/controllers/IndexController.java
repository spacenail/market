package com.github.spacenail.market.controllers;

import com.github.spacenail.market.Model.Product;

import com.github.spacenail.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {
    private ProductService service;

    @GetMapping("/allProducts")
    public List<Product> product() {
    return service.getProducts();
    }

    @Autowired
    private void setProductService(ProductService service) {
        this.service = service;
    }

    @DeleteMapping("/deleteProduct")
    public void delete(long id){
        service.deleteProductById(id);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }
}
