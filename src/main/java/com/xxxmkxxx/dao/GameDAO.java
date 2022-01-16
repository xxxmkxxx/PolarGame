package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.UserModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameDAO {
    private SessionFactory sessionFactory;

    public GameModel getGameById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(GameModel.class, id);
    }

    public List<GameModel> getAllGames() {
        Session session = sessionFactory.getCurrentSession();
        String query = "from GameModel as game right join fetch game.genres as gameGenres";
        List<GameModel> result = (List<GameModel>) session.createQuery(query).list()
                .stream()
                .distinct()
                .collect(Collectors.toList());

        return result;
    }

    public GameModel initializeComments(GameModel game) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(game, LockMode.NONE);

        Hibernate.initialize(game.getComments());

        return game;
    }

    public void updateGame(GameModel game) {
        Session session = sessionFactory.getCurrentSession();
        session.update(game);
    }

    public GameDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
