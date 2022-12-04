package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao{
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public ProductDaoImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<Product> getProducts() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.getSession().
                    getNamedQuery("Product.findAll").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product getProduct(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }


    @Override
    public void delete(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.createQuery("delete from Product p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void delete(Product product) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }


}