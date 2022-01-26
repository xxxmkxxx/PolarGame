package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.TeamMessageModel;

import java.text.SimpleDateFormat;

public class TeamMessageModelWrapper extends AbstractWrapper<TeamMessageModelWrapper, TeamMessageModel> {
    private String text;
    private String date;
    private UserModelWrapper user;

    public TeamMessageModelWrapper() {}

    public TeamMessageModelWrapper(TeamMessageModel teamMessage) {
        this.text = teamMessage.getMessageText();
        this.date = new SimpleDateFormat().format(teamMessage.getMessageDate());
        this.user = new UserModelWrapper(teamMessage.getUser());
    }

    public TeamMessageModelWrapper(String text, String date, UserModelWrapper user) {
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserModelWrapper getUser() {
        return user;
    }

    public void setUser(UserModelWrapper user) {
        this.user = user;
    }

    @Override
    public TeamMessageModelWrapper convertModel(TeamMessageModel teamMessage) {
        return new TeamMessageModelWrapper(teamMessage);
    }
}
