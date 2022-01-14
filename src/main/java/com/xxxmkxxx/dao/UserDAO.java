package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.UserModel;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDAO {
    private static SessionFactory sessionFactory;

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

    public UserModel initializeFriends(UserModel user) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(user, LockMode.NONE);

        Hibernate.initialize(user.getFriends());

        return user;
    }

    public void removeFriend(UserModel user, UserModel friend) {
        Session session = sessionFactory.getCurrentSession();

        session.lock(user, LockMode.NONE);
        session.lock(friend, LockMode.NONE);

        Hibernate.initialize(user.getFriends());
        Hibernate.initialize(friend.getFriends());

        user.getFriends().remove(friend);
        friend.getFriends().remove(user);

        session.update(user);
    }

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
