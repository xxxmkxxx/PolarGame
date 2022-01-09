package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games_genres")
public class GameGenresModel implements Serializable {
    @Id
    @Column(name = "number_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numberId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel game;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenresModel genre;

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public GenresModel getGenre() {
        return genre;
    }

    public void setGenre(GenresModel genre) {
        this.genre = genre;
    }
}
