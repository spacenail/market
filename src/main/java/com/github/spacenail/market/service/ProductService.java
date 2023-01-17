package com.github.spacenail.market.service;

import com.github.spacenail.market.Model.Product;
import com.github.spacenail.market.repo.ProductDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    private ProductDaoImp repo;

@Autowired
    public void setRepo(ProductDaoImp repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
    return repo.getProducts();
    }

    public void deleteProductById(long id) {
    repo.delete(id);
    }

    public void addProduct(Product product) {
    repo.saveOrUpdate(product);
    }
}
