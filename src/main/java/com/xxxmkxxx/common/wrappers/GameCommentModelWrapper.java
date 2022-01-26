package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GameCommentModel;

import java.util.Date;

public class GameCommentModelWrapper extends AbstractWrapper<GameCommentModelWrapper, GameCommentModel> {
    private int commentId;
    private String text;
    private Date date;
    private UserModelWrapper user;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public UserModelWrapper getUser() {
        return user;
    }

    public void setUser(UserModelWrapper user) {
        this.user = user;
    }

    @Override
    public GameCommentModelWrapper convertModel(GameCommentModel gameComment) {
        this.commentId = gameComment.getCommentId();
        this.text = gameComment.getText();
        this.date = gameComment.getDate();
        this.user = new UserModelWrapper(gameComment.getUser());

        return this;
    }

    public GameCommentModelWrapper() {
    }

    public GameCommentModelWrapper(GameCommentModel gameComment) {
        convertModel(gameComment);
    }

    public GameCommentModelWrapper(int commentId, String text, Date date, UserModelWrapper user) {
        this.commentId = commentId;
        this.text = text;
        this.date = date;
        this.user = user;
    }
}
