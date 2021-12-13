package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PartyMemberDAO {
    private DataManager<PartyMemberModel> data;

    @Transactional
    public List<PartyMemberModel> getMembersByPartyId(int partyId) {
        return data.read(PartyMemberModel.class, "from PartyMemberModel where partyId = " + partyId);
    }

    @Transactional
    public List<PartyMemberModel> getAllMembers() {
        return data.read(PartyMemberModel.class, "from PartyMemberModel");
    }

    public PartyMemberDAO(DataManager data) {
        this.data = data;
    }
}
