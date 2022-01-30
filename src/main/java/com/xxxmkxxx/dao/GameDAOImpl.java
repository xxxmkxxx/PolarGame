package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class GameDAOImpl extends AbstractDAO<GameModel> implements GameDAO {
    private SessionFactory sessionFactory;

    public GameDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public GameModel initializeComments(GameModel game) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(game, LockMode.NONE);

        Hibernate.initialize(game.getComments());

        return game;
    }

    @Override
    public GameModel initializeParties(GameModel game) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(game, LockMode.NONE);

        Hibernate.initialize(game.getParties());

        return game;
    }

    @Override
    public GameModel initializeTeams(GameModel game) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(game, LockMode.NONE);

        Hibernate.initialize(game.getTeams());

        return game;
    }
}
