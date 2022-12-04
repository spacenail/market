package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product getProduct(Long id);
    void delete(Long id);
    Product saveOrUpdate(Product product);
}
