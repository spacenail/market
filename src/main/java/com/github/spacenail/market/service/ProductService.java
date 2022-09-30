package com.github.spacenail.market.service;

import com.github.spacenail.market.repo.InMemoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private InMemoryRepo repo;

@Autowired
    public void setRepo(InMemoryRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts(){
        return repo.getProductList();
    }

    public Product getProductById(long id){
        return repo.getById(id);
    }
}
