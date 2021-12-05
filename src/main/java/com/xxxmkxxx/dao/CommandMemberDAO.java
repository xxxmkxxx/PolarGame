package com.xxxmkxxx.dao;

import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;

@Component
public class CommandMemberDAO {
    private DataManager data;

    public CommandMemberDAO(DataManager data) {
        this.data = data;
    }
}
