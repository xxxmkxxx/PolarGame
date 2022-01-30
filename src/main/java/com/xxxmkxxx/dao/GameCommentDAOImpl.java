package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameCommentModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class GameCommentDAOImpl extends AbstractDAO<GameCommentModel> implements GameCommentDAO {
    private SessionFactory sessionFactory;

    public GameCommentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
