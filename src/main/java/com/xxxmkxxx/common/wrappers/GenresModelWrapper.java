package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GenresModel;

public class GenresModelWrapper extends AbstractWrapper<GenresModelWrapper, GenresModel> {
    private int genreId;
    private String genreName;

    public GenresModelWrapper() {}

    public GenresModelWrapper(GenresModel genre) {
        convertModel(genre);
    }

    public GenresModelWrapper(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

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

    @Override
    public GenresModelWrapper convertModel(GenresModel genre) {
        this.genreId = genre.getGenreId();
        this.genreName = genre.getGenreName();

        return this;
    }
}
