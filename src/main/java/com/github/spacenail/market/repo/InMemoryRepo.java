package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryRepo {
    private List<Product> productList;

@PostConstruct
 private void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L,"iphone",1000),
                new Product(2L,"Xiaomi",500),
                new Product(3L, "ZTE",600),
                new Product(4L, "Samsung",800)
        ));
 }

    public Product getById(long id){
        return productList.stream().filter(
                product -> product.getId()==id).
                findFirst().orElseThrow(()->new RuntimeException("Product is not found"));
    }

    public List<Product> getProductList(){
    return productList;
    }

    public void delete(long id) {
    productList.remove(getById(id));
    }
}
