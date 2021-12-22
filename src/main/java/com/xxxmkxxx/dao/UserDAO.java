package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDAO {
    private SessionFactory sessionFactory;

    public UserModel getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(UserModel.class, id);
    }

    public UserModel getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        String query =
                "from UserModel user " +
                "where user.login = " + "\'" + login + "\'";

        List<UserModel> users = session.createQuery(query).getResultList();

        if(users.size() == 0)
            return new UserModel();
        else
            return users.get(0);

    }

    public UserModel getUserByMail(String mail) {
        Session session = sessionFactory.getCurrentSession();
        String query =
                "from UserModel user " +
                "where user.mail = " + "\'" + mail + "\'";

        List<UserModel> users = session.createQuery(query).getResultList();

        if(users.size() == 0)
            return new UserModel();
        else
            return users.get(0);
    }

    public void saveUser(UserModel user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
