package com.xxxmkxxx.common.wrappers;

import javax.persistence.Column;

public class GenresModelWrapper {
    private int genreId;
    private String genreName;

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

    public GenresModelWrapper(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }
}
