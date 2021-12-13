package com.xxxmkxxx.services;

import com.xxxmkxxx.models.PartyMemberModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartyMembersService {
    public static List<PartyMemberModel> getGropedPartyMembers(int partyId, List<PartyMemberModel> allMembers) {
        List<PartyMemberModel> resultMembers = new ArrayList();

        for (PartyMemberModel member : allMembers) {
            if(member.getPartyId() == partyId)
                resultMembers.add(member);
        }

        return resultMembers;
    }
}
