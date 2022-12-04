package com.github.spacenail.market.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private SessionFactory sessionFactory;

    public SessionFactoryUtils() {
    }

    public Session getSession(){
     if (sessionFactory == null){
         sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                 buildSessionFactory();
     }
     return sessionFactory.getCurrentSession();
 }
}
