package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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

    @ManyToMany
    @JoinTable(
            name = "friends",
            joinColumns = {@JoinColumn(name = "friend_1")},
            inverseJoinColumns = {@JoinColumn(name = "friend_2")}
    )
    private List<UserModel> friends = new ArrayList();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<GameCommentModel> gameComments;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private PartyMemberModel partyMember;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<TeamMessageModel> teamMessages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<TeamMemberModel> teamMembers;

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

    public List<UserModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserModel> friends) {
        this.friends = friends;
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

    public List<TeamMessageModel> getTeamMessages() {
        return teamMessages;
    }

    public void setTeamMessages(List<TeamMessageModel> teamMessages) {
        this.teamMessages = teamMessages;
    }

    public List<TeamMemberModel> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberModel> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public UserModel() {}

    public UserModel(int userId, String login, String password, String mail, String description, String urlUserIcon, List<UserModel> friends, List<GameCommentModel> gameComments, PartyMemberModel partyMember, List<TeamMessageModel> teamMessages, List<TeamMemberModel> teamMembers) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.description = description;
        this.urlUserIcon = urlUserIcon;
        this.friends = friends;
        this.gameComments = gameComments;
        this.partyMember = partyMember;
        this.teamMessages = teamMessages;
        this.teamMembers = teamMembers;
    }

    public UserModel(String login, String password, String mail) {
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.description = "";
        this.urlUserIcon = "profile_icon.png";
    }
}
