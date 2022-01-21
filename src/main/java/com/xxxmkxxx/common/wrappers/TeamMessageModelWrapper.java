package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.TeamMessageModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TeamMessageModelWrapper extends Wrapper<TeamMessageModelWrapper, TeamMessageModel> {
    private String text;
    private String date;
    private UserModelWrapper user;

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
    public List<TeamMessageModelWrapper> convertList(List<TeamMessageModel> models) {
        List<TeamMessageModelWrapper> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(new TeamMessageModelWrapper(models.get(i)));
        }

        return result;
    }

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
}
