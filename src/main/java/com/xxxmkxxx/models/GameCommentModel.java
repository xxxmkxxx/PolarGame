package com.xxxmkxxx.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game_comments")
public class GameCommentModel {
    @Id
    @Column(name = "id_comment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "game_id")
    private int gameId;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "date_time")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
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
}
