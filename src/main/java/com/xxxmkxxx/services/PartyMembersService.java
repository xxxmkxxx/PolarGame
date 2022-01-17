package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.PartyMemberDAO;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PartyMembersService {
    private PartyMemberDAO partyMemberDAO;

    @Transactional
    public UserModel getOwner(List<PartyMemberModel> members) {
        UserModel user = new UserModel();

        for (PartyMemberModel member : members) {
            if(member.getRole().equals("создатель"))
                user = member.getUser();
        }

        return user;
    }

    @Transactional
    public void addPartyMember(String role, UserModel user, PartyModel party) {
        PartyMemberModel partyMember = new PartyMemberModel(user, party, "temp", role);

        partyMemberDAO.savePartyMember(partyMember);
    }

    public PartyMembersService(PartyMemberDAO partyMemberDAO) {
        this.partyMemberDAO = partyMemberDAO;
    }
}

