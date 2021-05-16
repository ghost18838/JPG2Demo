package com.company.service;

import com.company.dao.DAO;
import com.company.model.ProductSale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductSaleService implements DAO<ProductSale, Integer> {
    private SessionFactory sessionFactory;
    public ProductSaleService(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List<ProductSale> readByAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("FROM ProductSale",ProductSale.class).list();
        }
    }

    @Override
    public ProductSale read(Integer integer) {
        try(Session session = sessionFactory.openSession()){
            return session.get(ProductSale.class,integer);
        }
    }

    @Override
    public void create(ProductSale object) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ProductSale object) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ProductSale object) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }
    }
}
