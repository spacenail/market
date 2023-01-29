package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
