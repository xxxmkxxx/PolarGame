package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.PartyMemberDAOImpl;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PartyMembersService {
    private PartyMemberDAOImpl dao;

    public PartyMembersService(PartyMemberDAOImpl dao) {
        this.dao = dao;
    }

    @Transactional
    public void addPartyMember(String role, UserModel user, PartyModel party) {
        PartyMemberModel partyMember = new PartyMemberModel(user, party, "temp", role);

        dao.create(partyMember);
    }

    @Transactional
    public PartyModel initializePartyMembers(PartyModel party) {
        return dao.initPartyMembers(party);
    }
}

