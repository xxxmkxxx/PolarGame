package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class GameDAO {
    private DataManager data;

    public GameDAO(DataManager data) {
        this.data = data;
    }
}
