package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games_genres")
public class GameGenresModel implements Serializable {
    @Id
    @Column(name = "id_games_genres")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numberId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_game")
    private GameModel game;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_genre")
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

    public GameGenresModel() {}

    public GameGenresModel(int numberId, GameModel game, GenresModel genre) {
        this.numberId = numberId;
        this.game = game;
        this.genre = genre;
    }
}
