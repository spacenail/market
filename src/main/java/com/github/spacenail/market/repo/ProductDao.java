package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductDao {

    private SessionFactory sessionFactory;

    @PostConstruct
    private void init(){
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                buildSessionFactory();
    }

    public List<Product> getProducts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = session.getSession().
                getNamedQuery("Product.findAll").getResultList();
        session.getTransaction().commit();
        return products;
    }
}