package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private int teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_password")
    private String teamPassword;

    @Column(name = "privacy")
    private String teamPrivacy;

    @Column(name = "team_icon")
    private String urlTeamIcon;

    @Column(name = "gamers_amount")
    private int teamGamersAmount;

    @Column(name = "team_description")
    private String teamDescription;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private GameModel game;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<TeamMessageModel> messages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<TeamMemberModel> members;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    public String getTeamPrivacy() {
        return teamPrivacy;
    }

    public void setTeamPrivacy(String teamPrivacy) {
        this.teamPrivacy = teamPrivacy;
    }

    public String getUrlTeamIcon() {
        return urlTeamIcon;
    }

    public void setUrlTeamIcon(String urlTeamIcon) {
        this.urlTeamIcon = urlTeamIcon;
    }

    public int getTeamGamersAmount() {
        return teamGamersAmount;
    }

    public void setTeamGamersAmount(int teamGamersAmount) {
        this.teamGamersAmount = teamGamersAmount;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public List<TeamMessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<TeamMessageModel> messages) {
        this.messages = messages;
    }

    public List<TeamMemberModel> getMembers() {
        return members;
    }

    public void setMembers(List<TeamMemberModel> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamModel teamModel = (TeamModel) o;
        return teamId == teamModel.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId);
    }

    public TeamModel() {}

    public TeamModel(int teamId, String teamName, String teamPassword, String teamPrivacy, String urlTeamIcon, int teamGamersAmount, String teamDescription, GameModel game, List<TeamMessageModel> messages, List<TeamMemberModel> members) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamPassword = teamPassword;
        this.teamPrivacy = teamPrivacy;
        this.urlTeamIcon = urlTeamIcon;
        this.teamGamersAmount = teamGamersAmount;
        this.teamDescription = teamDescription;
        this.game = game;
        this.messages = messages;
        this.members = members;
    }
}
