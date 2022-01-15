package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameCommentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameCommentDAO {
    private SessionFactory sessionFactory;

    public void saveComment(GameCommentModel comment) {
        Session session = sessionFactory.getCurrentSession();

        session.save(comment);
    }

    public GameCommentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
