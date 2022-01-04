package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.PartyDAO;
import com.xxxmkxxx.models.PartyModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartyService {
    private PartyDAO partyDAO;

    @Transactional
    public List<PartyModel> getParties(int gameId) {
        return new ArrayList(partyDAO.getAllParties(gameId));
    }

    @Transactional
    public List<List<PartyModel>> groupParties(int count, List<PartyModel> parties) {
        if(parties.size() == 0)
            return new ArrayList();

        List<List<PartyModel>> partyGroups = new ArrayList();
        List<PartyModel> group = new ArrayList();
        int indexPartyInRow = 0;

        for (int i = 0; i < parties.size(); i++) {
            if(indexPartyInRow % count != 0 || indexPartyInRow == 0) {
                group.add(parties.get(i));
            } else {
                indexPartyInRow = 0;
                partyGroups.add(group);
                group = new ArrayList();
                group.add(parties.get(i));
            }

            if(i == parties.size() - 1)
                partyGroups.add(group);

            indexPartyInRow++;
        }

        return partyGroups;
    }

    @Transactional
    public List<PartyModel> getPartiesByPattern(String pattern, int gameId) {
        final String temp = pattern;
        List<PartyModel> resultPartiesList = new ArrayList();

        for(PartyModel party : getParties(gameId)) {
            boolean flag = party.getMembers()
                    .stream()
                    .anyMatch(member -> member.getUser().getLogin().contains(temp));

            if(flag) {
                resultPartiesList.add(party);
            }
        }

        return resultPartiesList;
    }

    public PartyService(PartyDAO partyDAO) {
        this.partyDAO = partyDAO;
    }
}
