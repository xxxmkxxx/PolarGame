package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "party_members")
public class PartyMemberModel implements Serializable {
    @Id
    @Column(name = "id_party_members")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyMemberId;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_user")
    private UserModel user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_party")
    private PartyModel party;

    @Column(name = "nickname")
    private String nick;

    @Column(name = "party_member_role")
    private String role;

    public int getPartyMemberId() {
        return partyMemberId;
    }

    public void setPartyMemberId(int partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PartyModel getParty() {
        return party;
    }

    public void setParty(PartyModel party) {
        this.party = party;
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

    public PartyMemberModel() {}

    public PartyMemberModel(int partyMemberId, UserModel user, PartyModel party, String nick, String role) {
        this.partyMemberId = partyMemberId;
        this.user = user;
        this.party = party;
        this.nick = nick;
        this.role = role;
    }

    public PartyMemberModel(UserModel user, PartyModel party, String nick, String role) {
        this.user = user;
        this.party = party;
        this.nick = nick;
        this.role = role;
    }
}
