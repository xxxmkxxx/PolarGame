package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.UserModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PartyMemberDAO {
    private SessionFactory sessionFactory;

    public PartyMemberDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
