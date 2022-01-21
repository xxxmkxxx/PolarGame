package com.xxxmkxxx.services;

import com.xxxmkxxx.common.wrappers.GenresModelWrapper;
import com.xxxmkxxx.common.wrappers.Wrapper;
import com.xxxmkxxx.dao.GenresDAO;
import com.xxxmkxxx.models.GenresModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GenresService {
    private GenresDAO genresDAO;

    @Transactional
    public List<GenresModel> getGenres() {
        return genresDAO.getAllGenres();
    }

    @Transactional
    public List<GenresModelWrapper> getGenresWrapper() {
        List<GenresModel> genres = getGenres();
        Wrapper<GenresModelWrapper, GenresModel> wrapper = new GenresModelWrapper();

        return wrapper.convertList(genres);
    }

    public GenresService(GenresDAO genresDAO) {
        this.genresDAO = genresDAO;
    }
}
