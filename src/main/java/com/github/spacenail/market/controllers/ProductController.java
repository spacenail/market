package com.github.spacenail.market.controllers;

import com.github.spacenail.market.model.Product;

import com.github.spacenail.market.service.ProductServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductServiceData service;

    @Autowired
    private void setProductService(ProductServiceData service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> products() {
    return service.getProducts();
    }

    @GetMapping("/{id}")
    @Secured("ROLE-ADMIN")
    public Product product(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable Long id){
        service.deleteProductById(id);
    }

    @PostMapping("/admin")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @PutMapping("/admin")
    public void updateProduct(@RequestBody Product product){service.updateProduct(product);
    }
}
