package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GenresModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class GenresDAOImpl extends AbstractDAO<GenresModel> {
    private SessionFactory factory;

    public GenresDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }
}
