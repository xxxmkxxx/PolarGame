package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GameModel;

public class GameModelWrapper extends AbstractWrapper<GameModelWrapper, GameModel> {
    private int gameId;
    private String name;
    private String description;
    private String urlGameIcon;
    private int popularity;

    public GameModelWrapper() {}

    public GameModelWrapper(GameModel game) {
        convertModel(game);
    }

    public GameModelWrapper(int gameId, String name, String description, String urlGameIcon, int popularity) {
        this.gameId = gameId;
        this.name = name;
        this.description = description;
        this.urlGameIcon = urlGameIcon;
        this.popularity = popularity;
    }

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

    @Override
    public GameModelWrapper convertModel(GameModel game) {
        this.gameId = game.getGameId();
        this.name = game.getName();
        this.description = game.getDescription();
        this.urlGameIcon = game.getUrlGameIcon();
        this.popularity = game.getPopularity();

        return this;
    }
}
