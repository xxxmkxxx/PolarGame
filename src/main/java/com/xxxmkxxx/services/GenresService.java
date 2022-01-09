package com.xxxmkxxx.services;

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

    public GenresService(GenresDAO genresDAO) {
        this.genresDAO = genresDAO;
    }
}
