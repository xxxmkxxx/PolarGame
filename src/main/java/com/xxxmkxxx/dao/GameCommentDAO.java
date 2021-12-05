package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class GameCommentDAO {
    private DataManager data;

    public GameCommentDAO(DataManager data) {
        this.data = data;
    }
}
