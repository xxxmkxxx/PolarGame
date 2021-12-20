package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PartyDAO {
    private SessionFactory sessionFactory;

    @Transactional
    public Set<PartyModel> getAllParties(int gameId) {
        Session session = sessionFactory.getCurrentSession();
        String query = "from PartyModel as p right join fetch p.members as m where p.gameId = " + gameId;

        return new HashSet(session.createQuery(query).getResultList());
    }

    public PartyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
