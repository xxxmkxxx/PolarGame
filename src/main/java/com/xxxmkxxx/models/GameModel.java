package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class GameModel {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_description")
    private String description;

    @Column(name = "game_icon_link")
    private String urlGameIcon;

    @Column(name = "popularity")
    private String popularity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    private List<PartyModel> parties;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlGameIcon() {
        return urlGameIcon;
    }

    public void setUrlGameIcon(String urlGameIcon) {
        this.urlGameIcon = urlGameIcon;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public List<PartyModel> getParties() {
        return parties;
    }

    public void setParties(List<PartyModel> parties) {
        this.parties = parties;
    }
}
