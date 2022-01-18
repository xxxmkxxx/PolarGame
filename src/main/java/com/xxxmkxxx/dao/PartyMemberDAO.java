package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PartyMemberDAO {
    private SessionFactory sessionFactory;

    public void savePartyMember(PartyMemberModel partyMember) {
        Session session = sessionFactory.getCurrentSession();
        session.save(partyMember);
    }

    public PartyModel initPartyMembers(PartyModel party) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(party, LockMode.NONE);

        Hibernate.initialize(party.getMembers());

        return party;
    }

    public PartyMemberDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
