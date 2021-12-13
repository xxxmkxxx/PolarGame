package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PartyDAO {
    private DataManager<PartyModel> data;

    @Transactional
    public List<PartyModel> getAllParties(int gameId) {
        return data.read(PartyModel.class, "from PartyModel where game_id = " + gameId);
    }

    public PartyDAO(DataManager data) {
        this.data = data;
    }
}
