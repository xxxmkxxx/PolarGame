package com.xxxmkxxx.services;

import com.xxxmkxxx.storage.IDataAccessLayer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DataBaseService <T> implements IDataAccessLayer {
    private SessionFactory sessionFactory;

    @Override
    public T read(int id, Class model) {
        Session session = sessionFactory.getCurrentSession();

        return (T) session.get(model, id);
    }

    @Override
    public List<T> read(Class model) {
        Session session = sessionFactory.getCurrentSession();

        return (List<T>) session.createQuery("from " + model.getName()).list();
    }

    @Override
    public List<T> read(Class model, String query) {
        Session session = sessionFactory.getCurrentSession();

        return (List<T>) session.createQuery(query).list();
    }

    @Override
    public void delete(int id, Class model) {

    }

    @Override
    public void update(int id, Class model) {

    }

    @Override
    public void create(Class model) {

    }

    public DataBaseService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
