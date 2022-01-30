package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamMessageModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamMessageDataBaseDAOImpl extends AbstractDataBaseDAO<TeamMessageModel> {
    SessionFactory sessionFactory;

    public TeamMessageDataBaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
