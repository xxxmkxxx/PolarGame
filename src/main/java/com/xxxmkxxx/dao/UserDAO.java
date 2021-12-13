package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private DataManager<UserModel> data;

    public UserModel getUserById(int id) {
        return data.read(id, UserModel.class);
    }

    public UserDAO(DataManager data) {
        this.data = data;
    }
}
