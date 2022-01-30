package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PartyDAOImpl extends AbstractDAO<PartyModel> {
    private SessionFactory sessionFactory;

    public PartyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
