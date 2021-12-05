package com.xxxmkxxx.models;

import java.util.List;

public class GameCommandModel {
    private int commandId;
    private int ownerId;
    private int gameId;
    private String title;
    private String description;
    private float popularity;
    private List<UserModel> members;

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public List<UserModel> getMembers() {
        return members;
    }

    public void setMembers(List<UserModel> members) {
        this.members = members;
    }

    public GameCommandModel(int commandId, int ownerId, int gameId, String title, String description, float popularity, List<UserModel> members) {
        this.commandId = commandId;
        this.ownerId = ownerId;
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.popularity = popularity;
        this.members = members;
    }
}
