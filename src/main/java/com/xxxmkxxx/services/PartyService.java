package com.xxxmkxxx.services;

import com.xxxmkxxx.models.PartyModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartyService {
    public static List<List<PartyModel>> groupParties(int count, List<PartyModel> parties) {
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
}
