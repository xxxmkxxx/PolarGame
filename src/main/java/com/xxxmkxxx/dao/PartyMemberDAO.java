package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PartyMemberDAO {
    private SessionFactory sessionFactory;

    public PartyMemberDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
