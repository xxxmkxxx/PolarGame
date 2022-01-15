package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "game")
public class GameModel implements Serializable {
    @Id
    @Column(name = "id_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_description")
    private String description;

    @Column(name = "game_icon_link")
    private String urlGameIcon;

    @Column(name = "popularity")
    private int popularity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    private List<GameCommentModel> comments;

    @ManyToMany
    @JoinTable(
            name = "games_genres",
            joinColumns = @JoinColumn(name = "id_game"),
            inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private List<GenresModel> genres;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlGameIcon() {
        return urlGameIcon;
    }

    public void setUrlGameIcon(String urlGameIcon) {
        this.urlGameIcon = urlGameIcon;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<GameCommentModel> getComments() {
        return comments;
    }

    public void setComments(List<GameCommentModel> comments) {
        this.comments = comments;
    }

    public List<GenresModel> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresModel> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameModel gameModel = (GameModel) o;
        return gameId == gameModel.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId);
    }

    public GameModel() {}

    public GameModel(int gameId, String name, String description, String urlGameIcon, int popularity, List<GameCommentModel> comments, List<GenresModel> genres) {
        this.gameId = gameId;
        this.name = name;
        this.description = description;
        this.urlGameIcon = urlGameIcon;
        this.popularity = popularity;
        this.comments = comments;
        this.genres = genres;
    }
}
