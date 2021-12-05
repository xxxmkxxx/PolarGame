package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class PartyMemberDAO {
    private DataManager data;

    public PartyMemberDAO(DataManager data) {
        this.data = data;
    }
}
