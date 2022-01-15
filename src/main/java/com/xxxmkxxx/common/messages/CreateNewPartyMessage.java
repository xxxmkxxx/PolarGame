package com.xxxmkxxx.common.messages;

public class CreateNewPartyMessage {
    private int gameId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public CreateNewPartyMessage() {}

    public CreateNewPartyMessage(int gameId) {
        this.gameId = gameId;
    }
}
