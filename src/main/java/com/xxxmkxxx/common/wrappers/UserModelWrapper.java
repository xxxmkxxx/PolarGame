package com.xxxmkxxx.common.wrappers;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserModelWrapper {
    private int userId;
    private String login;
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserModelWrapper(int userId, String login, String password, String mail, String description, String urlUserIcon) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.description = description;
        this.urlUserIcon = urlUserIcon;
    }
}
