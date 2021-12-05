package com.xxxmkxxx.models;

public class PartyModel {
    private int partyId;
    private int gameId;
    private int ownerId;
    private int usersCount;
    private boolean closed = false;
    private String description;
    private String urlPartyIcon;

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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
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

    public PartyModel(int partyId, int gameId, int ownerId, int usersCount, boolean closed, String description, String urlPartyIcon) {
        this.partyId = partyId;
        this.gameId = gameId;
        this.ownerId = ownerId;
        this.usersCount = usersCount;
        this.closed = closed;
        this.description = description;
        this.urlPartyIcon = urlPartyIcon;
    }
}
