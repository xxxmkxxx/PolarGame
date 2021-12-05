package com.xxxmkxxx.models;

import java.util.Date;

public class GameCommentModel {
    private int commentId;
    private int gameId;
    private int userId;
    private String text;
    private Date date;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GameCommentModel(int commentId, int gameId, int userId, String text, Date date) {
        this.commentId = commentId;
        this.gameId = gameId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }
}
