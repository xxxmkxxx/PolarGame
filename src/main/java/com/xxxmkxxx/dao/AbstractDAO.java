package com.xxxmkxxx.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDataBaseDAO<T> implements DAO<T>{
    protected SessionFactory sessionFactory;
    protected Class<T> modelClass;

    public boolean create(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.save(model);

        return true;
    }

    public List<T> read() {
        Session session = sessionFactory.getCurrentSession();
        String query = "FROM " + modelClass.getName();

        return session.createQuery(query).getResultList();
    }

    public T read(int index) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(modelClass, index);
    }

    public boolean update(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.update(model);

        return true;
    }

    public boolean delete(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(model);

        return true;
    }
}
