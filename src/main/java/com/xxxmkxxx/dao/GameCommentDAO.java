package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameCommentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class GameCommentDAO {
    private SessionFactory sessionFactory;

    @Transactional
    public List<GameCommentModel> getAllComments(int gameId) {
        Session session = sessionFactory.getCurrentSession();
        String query = "from GameCommentModel as gameComment right join fetch gameComment.user where gameComment.gameId = " + gameId;

        return session.createQuery(query).getResultList();
    }

    public GameCommentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
