package com.xxxmkxxx.models;

import com.xxxmkxxx.common.PartyMemberRoles;

public class PartyMemberModel {
    private int partyId;
    private int userId;
    private String nick;
    private PartyMemberRoles role;

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public PartyMemberRoles getRole() {
        return role;
    }

    public void setRole(PartyMemberRoles role) {
        this.role = role;
    }

    public PartyMemberModel(int partyId, int userId, String nick, PartyMemberRoles role) {
        this.partyId = partyId;
        this.userId = userId;
        this.nick = nick;
        this.role = role;
    }
}
