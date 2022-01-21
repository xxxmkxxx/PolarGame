package com.xxxmkxxx.common.wrappers;

public class GameModelWrapper {
    private int gameId;
    private String name;
    private String description;
    private String urlGameIcon;
    private int popularity;

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

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public GameModelWrapper(int gameId, String name, String description, String urlGameIcon, int popularity) {
        this.gameId = gameId;
        this.name = name;
        this.description = description;
        this.urlGameIcon = urlGameIcon;
        this.popularity = popularity;
    }
}
