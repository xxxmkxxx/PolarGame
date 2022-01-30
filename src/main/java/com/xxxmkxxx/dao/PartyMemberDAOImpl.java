package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PartyMemberDataBaseDAOImpl extends AbstractDataBaseDAO<PartyMemberModel> implements PartyMemberDAO {
    private SessionFactory sessionFactory;

    public PartyMemberDataBaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PartyModel initPartyMembers(PartyModel party) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(party, LockMode.NONE);

        Hibernate.initialize(party.getMembers());

        return party;
    }
}
