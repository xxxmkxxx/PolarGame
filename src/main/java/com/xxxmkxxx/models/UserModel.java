package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<GameCommentModel> gameComments;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private PartyMemberModel partyMember;

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

    public PartyMemberModel getPartyMember() {
        return partyMember;
    }

    public void setPartyMember(PartyMemberModel partyMember) {
        this.partyMember = partyMember;
    }
}
