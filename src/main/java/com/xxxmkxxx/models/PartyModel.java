package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "party")
public class PartyModel {
    @Id
    @Column(name = "id_party")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel game;

    @ManyToOne
    @JoinColumn(name = "party_creator")
    private UserModel user;

    @Column(name = "gamers_amount")
    private int usersAmount;

    @Column(name = "privacy")
    private String closed;

    @Column(name = "party_description")
    private String description;

    @Column(name = "party_icon")
    private String urlPartyIcon;

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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
}
