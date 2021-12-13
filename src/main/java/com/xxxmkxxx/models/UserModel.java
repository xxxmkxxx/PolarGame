package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String mail;

    @Column(name = "user_description")
    private String description;

    @Column(name = "user_icon")
    private String urlUserIcon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<GameCommentModel> gameComments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PartyModel> parties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PartyMemberModel> partiesMember;

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

    public List<GameCommentModel> getGameComments() {
        return gameComments;
    }

    public void setGameComments(List<GameCommentModel> gameComments) {
        this.gameComments = gameComments;
    }

    public List<PartyModel> getParties() {
        return parties;
    }

    public void setParties(List<PartyModel> parties) {
        this.parties = parties;
    }

    public List<PartyMemberModel> getPartiesMember() {
        return partiesMember;
    }

    public void setPartiesMember(List<PartyMemberModel> partiesMember) {
        this.partiesMember = partiesMember;
    }
}
