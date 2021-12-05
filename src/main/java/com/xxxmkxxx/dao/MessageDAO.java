package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class MessageDAO {
    private DataManager data;

    public MessageDAO(DataManager data) {
        this.data = data;
    }
}
