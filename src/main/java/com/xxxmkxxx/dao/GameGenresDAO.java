package com.xxxmkxxx.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class GameGenresDAO {
    private SessionFactory factory;



    public GameGenresDAO(SessionFactory factory) {
        this.factory = factory;
    }
}
