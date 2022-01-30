package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamMessageModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamMessageDAOImpl extends AbstractDAO<TeamMessageModel> {
    SessionFactory sessionFactory;

    public TeamMessageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
