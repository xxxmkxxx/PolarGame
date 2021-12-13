package com.xxxmkxxx.models;

import javax.persistence.*;

@Entity
@Table(name = "party_members")
public class PartyMemberModel {
    @Id
    @Column(name = "id_member")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyMemberId;

    @Column(name = "party_id")
    private int partyId;

    @ManyToOne
    @JoinColumn(name = "members_party_id")
    private UserModel user;

    @Column(name = "nickname")
    private String nick;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }
}
