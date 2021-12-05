package com.xxxmkxxx.models;

import com.xxxmkxxx.common.GameGenres;

public class GameModel {
    private int gameId;
    private String name;
    private GameGenres genre;
    private String description;
    private String urlGameIcon;
    private String popularity;

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

    public GameGenres getGenre() {
        return genre;
    }

    public void setGenre(GameGenres genre) {
        this.genre = genre;
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

    public GameModel(int gameId, String name, GameGenres genre, String description, String urlGameIcon, String popularity) {
        this.gameId = gameId;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.urlGameIcon = urlGameIcon;
        this.popularity = popularity;
    }
}
