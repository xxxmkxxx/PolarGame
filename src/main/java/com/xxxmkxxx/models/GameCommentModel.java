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

    @Column(name = "comment_text")
    private String text;

    @Column(name = "date_time")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private GameModel game;

    @ManyToOne
    @JoinColumn(name="id_user")
    private UserModel user;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public GameCommentModel() {}

    public GameCommentModel(int commentId, String text, Date date, GameModel game, UserModel user) {
        this.commentId = commentId;
        this.text = text;
        this.date = date;
        this.game = game;
        this.user = user;
    }
}
