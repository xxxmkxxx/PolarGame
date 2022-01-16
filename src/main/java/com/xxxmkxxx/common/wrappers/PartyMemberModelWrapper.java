package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.PartyMemberModel;

import java.util.ArrayList;
import java.util.List;

public class PartyMemberModelWrapper extends Wrapper<PartyMemberModelWrapper, PartyMemberModel> {
    private int partyMemberId;
    private UserModelWrapper user;
    private String nick;
    private String role;

    public int getPartyMemberId() {
        return partyMemberId;
    }

    public void setPartyMemberId(int partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public UserModelWrapper getUser() {
        return user;
    }

    public void setUser(UserModelWrapper user) {
        this.user = user;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public List<PartyMemberModelWrapper> convertList(List<PartyMemberModel> models) {
        List<PartyMemberModelWrapper> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(new PartyMemberModelWrapper(models.get(i)));
        }

        return result;
    }

    public PartyMemberModelWrapper() {
    }

    public PartyMemberModelWrapper(PartyMemberModel partyMember) {
        this.partyMemberId = partyMember.getPartyMemberId();
        this.user = new UserModelWrapper(partyMember.getUser());
        this.nick = partyMember.getNick();
        this.role = partyMember.getRole();
    }

    public PartyMemberModelWrapper(int partyMemberId, UserModelWrapper user, String nick, String role) {
        this.partyMemberId = partyMemberId;
        this.user = user;
        this.nick = nick;
        this.role = role;
    }
}
