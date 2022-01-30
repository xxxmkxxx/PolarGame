package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TeamDataBaseDAOImpl extends AbstractDataBaseDAO<TeamModel> implements TeamDAO {
    private SessionFactory sessionFactory;

    @Override
    public TeamModel initializeMessages(TeamModel team) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(team, LockMode.NONE);

        Hibernate.initialize(team.getMessages());

        return team;
    }

    @Override
    public TeamModel initializeMembers(TeamModel team) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(team, LockMode.NONE);

        Hibernate.initialize(team.getMembers());

        return team;
    }

    public TeamDataBaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
