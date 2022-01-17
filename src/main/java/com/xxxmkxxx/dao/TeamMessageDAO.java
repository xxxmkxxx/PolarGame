package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamMessageModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamMessageDAO {
    SessionFactory sessionFactory;

    public void saveMessage(TeamMessageModel message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
    }

    public TeamMessageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
