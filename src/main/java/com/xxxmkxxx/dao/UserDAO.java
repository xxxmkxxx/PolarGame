package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private DataManager data;

    public UserDAO(DataManager data) {
        this.data = data;
    }
}
