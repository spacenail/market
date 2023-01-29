package com.github.spacenail.market.service;

import com.github.spacenail.market.Model.Product;
import com.github.spacenail.market.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceData {
    private ProductRepo repo;
@Autowired
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
    return repo.findAll();
    }

    public void deleteProductById(Long id) {
    repo.deleteById(id);
    }

    public void addProduct(Product product) {
    product.setId(0L);
    repo.save(product);
    }

    public void updateProduct(Product product) {
    repo.save(product);
    }

    public Product getProduct(Long id) {
    return repo.findById(id).orElseThrow();
    }
}
