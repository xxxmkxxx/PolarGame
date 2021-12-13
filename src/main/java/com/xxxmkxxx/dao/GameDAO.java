package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GameDAO {
    private DataManager <GameModel> data;

    @Transactional
    public GameModel getGameById(int id) {
        return data.read(id, GameModel.class);
    }

    public GameDAO(DataManager data) {
        this.data = data;
    }
}
