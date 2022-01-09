package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameGenresModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameGenresDAO {
    private SessionFactory factory;



    public GameGenresDAO(SessionFactory factory) {
        this.factory = factory;
    }
}
