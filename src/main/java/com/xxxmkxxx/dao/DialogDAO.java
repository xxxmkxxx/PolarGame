package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class DialogDAO {
    private DataManager data;

    public DialogDAO(DataManager data) {
        this.data = data;
    }
}
