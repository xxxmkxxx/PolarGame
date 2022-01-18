package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamDAO {
    private SessionFactory sessionFactory;

    public TeamModel getTeam(int teamId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TeamModel.class, teamId);
    }

    public TeamModel initializeMessages(TeamModel team) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(team, LockMode.NONE);

        Hibernate.initialize(team.getMessages());

        return team;
    }

    public TeamModel initializeMembers(TeamModel team) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(team, LockMode.NONE);

        Hibernate.initialize(team.getMembers());

        return team;
    }

    public void updateTeam(TeamModel team) {
        Session session = sessionFactory.getCurrentSession();
        session.update(team);
    }

    public TeamDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
