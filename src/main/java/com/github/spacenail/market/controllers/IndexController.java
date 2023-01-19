package com.github.spacenail.market.controllers;

import com.github.spacenail.market.Model.Product;

import com.github.spacenail.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class IndexController {
    private ProductService service;

    @Autowired
    private void setProductService(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> product() {
    return service.getProducts();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteProductById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

  //  @PutMapping
    //public void updateProduct(@RequestBody Product product){
      //  service.saveOrUpdate(product);
    //}
}
