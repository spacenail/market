package com.github.spacenail.market.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {
    private SessionFactory sessionFactory;

    public SessionFactoryUtils() {
        sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                buildSessionFactory();
    }
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
