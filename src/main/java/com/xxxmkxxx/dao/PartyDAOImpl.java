package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PartyDataBaseDAOImpl extends AbstractDataBaseDAO<PartyModel> implements PartyDAO {
    private SessionFactory sessionFactory;

    public PartyDataBaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
