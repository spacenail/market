package com.github.spacenail.market.service;

import com.github.spacenail.market.Model.Product;
import com.github.spacenail.market.repo.InMemoryRepo;
import com.github.spacenail.market.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDao repo;

@Autowired
    public void setRepo(ProductDao repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
    return repo.getProducts();
    }

    public void deleteProductById(long id) {
    }
}
