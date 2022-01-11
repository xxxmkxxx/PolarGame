package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.UserModel;
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

    public PartyMemberDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
