package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "game_comments")
public class GameCommentModel implements Serializable {
    @Id
    @Column(name = "id_comment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "id_game")
    private int gameId;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "date_time")
    private Date date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id_user")
    private UserModel user;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public GameCommentModel() {}

    public GameCommentModel(int commentId, int gameId, String text, Date date, UserModel user) {
        this.commentId = commentId;
        this.gameId = gameId;
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public GameCommentModel(int gameId, String text, UserModel user) {
        this.gameId = gameId;
        this.text = text;
        this.user = user;
    }
}
