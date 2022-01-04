package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameCommentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameCommentDAO {
    private SessionFactory sessionFactory;

    public List<GameCommentModel> getAllComments(int gameId) {
        Session session = sessionFactory.getCurrentSession();
        String query = "from GameCommentModel as gameComment right join fetch gameComment.user where gameComment.gameId = " + gameId;

        return session.createQuery(query).getResultList();
    }

    public void saveComment(GameCommentModel comment) {
        Session session = sessionFactory.getCurrentSession();

        session.save(comment);
    }

    public GameCommentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
