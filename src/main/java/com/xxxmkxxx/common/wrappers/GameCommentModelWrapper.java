package com.xxxmkxxx.common.wrappers;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class GameCommentModelWrapper {
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

    public GameCommentModelWrapper(int commentId, String text, Date date, UserModelWrapper user) {
        this.commentId = commentId;
        this.text = text;
        this.date = date;
        this.user = user;
    }
}
