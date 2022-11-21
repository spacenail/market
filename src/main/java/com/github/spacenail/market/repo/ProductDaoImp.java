package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductDaoImp {

    public List<Product> getProducts() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.getSession().
                    getNamedQuery("Product.findAll").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}