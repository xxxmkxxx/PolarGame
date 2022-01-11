package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "party")
public class PartyModel implements Serializable {
    @Id
    @Column(name = "id_party")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyId;

    @Column(name = "game_id")
    private int gameId;

    @Column(name = "gamers_amount")
    private int usersAmount;

    @Column(name = "privacy")
    private String closed;

    @Column(name = "party_password")
    private String password;

    @Column(name = "party_description")
    private String description;

    @Column(name = "party_icon")
    private String urlPartyIcon;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "party")
    private List<PartyMemberModel> members;

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUsersAmount() {
        return usersAmount;
    }

    public void setUsersAmount(int usersAmount) {
        this.usersAmount = usersAmount;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPartyIcon() {
        return urlPartyIcon;
    }

    public void setUrlPartyIcon(String urlPartyIcon) {
        this.urlPartyIcon = urlPartyIcon;
    }

    public List<PartyMemberModel> getMembers() {
        return members;
    }

    public void setMembers(List<PartyMemberModel> members) {
        this.members = members;
    }

    public PartyModel() {}

    public PartyModel(int gameId, int usersAmount, String closed, String password, String description) {
        this.gameId = gameId;
        this.usersAmount = usersAmount;
        this.closed = closed;
        this.password = password;
        this.description = description;
        this.urlPartyIcon = "/images/filter_icon.png";
    }
}
