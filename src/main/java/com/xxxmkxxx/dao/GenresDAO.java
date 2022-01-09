package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GenresModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenresDAO {
    private SessionFactory factory;

    public List<GenresModel> getAllGenres() {
        Session session = factory.getCurrentSession();
        String query = "from GenresModel";

        return session.createQuery(query).getResultList();
    }

    public GenresDAO(SessionFactory factory) {
        this.factory = factory;
    }
}
