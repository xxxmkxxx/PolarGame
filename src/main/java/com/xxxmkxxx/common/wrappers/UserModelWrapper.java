package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelWrapper extends Wrapper<UserModelWrapper, UserModel> {
    private int userId;
    private String login;
    private String mail;
    private String description;
    private String urlUserIcon;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlUserIcon() {
        return urlUserIcon;
    }

    public void setUrlUserIcon(String urlUserIcon) {
        this.urlUserIcon = urlUserIcon;
    }

    @Override
    public List<UserModelWrapper> convertList(List<UserModel> models) {
        List<UserModelWrapper> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(new UserModelWrapper(models.get(i)));
        }

        return result;
    }

    public UserModelWrapper() {}

    public UserModelWrapper(UserModel user) {
        this.userId = user.getUserId();
        this.login = user.getLogin();
        this.mail = user.getMail();
        this.description = user.getDescription();
        this.urlUserIcon = user.getUrlUserIcon();
    }

    public UserModelWrapper(int userId, String login, String mail, String description, String urlUserIcon) {
        this.userId = userId;
        this.login = login;
        this.mail = mail;
        this.description = description;
        this.urlUserIcon = urlUserIcon;
    }
}
