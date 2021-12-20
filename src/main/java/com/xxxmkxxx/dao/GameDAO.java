package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameDAO {
    private SessionFactory sessionFactory;

    @Transactional
    public GameModel getGameById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(GameModel.class, id);
    }

    public List<GameModel> getAllGames() {
        Session session = sessionFactory.getCurrentSession();
        String query = "from GameModel game";

        return session.createQuery(query).list();
    }

    public GameDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
