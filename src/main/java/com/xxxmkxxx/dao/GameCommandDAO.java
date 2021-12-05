package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class GameCommandDAO {
    private DataManager data;

    public GameCommandDAO(DataManager data) {
        this.data = data;
    }
}
