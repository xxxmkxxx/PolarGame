package com.xxxmkxxx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenresModel implements Serializable {
    @Id
    @Column(name = "id_genre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(name = "genre")
    private String genreName;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private List<GameGenresModel> gameGenres;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<GameGenresModel> getGameGenres() {
        return gameGenres;
    }

    public void setGameGenres(List<GameGenresModel> gameGenres) {
        this.gameGenres = gameGenres;
    }

    public GenresModel() {}

    public GenresModel(int genreId, String genreName, List<GameGenresModel> gameGenres) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.gameGenres = gameGenres;
    }
}
