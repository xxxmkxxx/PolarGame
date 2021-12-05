package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class PartyDAO {
    private DataManager data;

    public PartyDAO(DataManager data) {
        this.data = data;
    }
}
