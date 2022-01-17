package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "team_messages")
public class TeamMessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int messageId;

    @Column(name = "date_time")
    private Date messageDate;

    @Column(name = "message_text")
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "id_sender")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private TeamModel team;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public TeamMessageModel() {}

    public TeamMessageModel(int messageId, Date messageDate, String messageText, UserModel user, TeamModel team) {
        this.messageId = messageId;
        this.messageDate = messageDate;
        this.messageText = messageText;
        this.user = user;
        this.team = team;
    }

    public TeamMessageModel(String messageText, UserModel user, TeamModel team) {
        this.messageDate = new Date();
        this.messageText = messageText;
        this.user = user;
        this.team = team;
    }
}
