package com.xxxmkxxx.services;

import com.xxxmkxxx.common.sorting.SortingGamesByPopularityComparator;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyModel;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GameService {
    private GameDAO gameDAO;

    @Transactional
    public GameModel getGame(int gameId) {
        return gameDAO.getGameById(gameId);
    }

    @Transactional
    public List<GameModel> getGames() {
        return gameDAO.getAllGames();
    }

    @Transactional
    public List<GameModel> getSortedGamesByPopularity(List<GameModel> games) {
        List<GameModel> sortedGames = games;
        SortingGamesByPopularityComparator comparator = new SortingGamesByPopularityComparator();

        Collections.sort(sortedGames, comparator);

        return sortedGames;
    }

    @Transactional
    public List<GameModel> getPopularGames(int count, List<GameModel> games) {
        return games.subList(0, count);
    }

    @Transactional
    public List<List<GameModel>> groupGames(int count, List<GameModel> games) {
        List<List<GameModel>> gameGroups = new ArrayList();
        List<GameModel> group = new ArrayList();
        int indexGameInRow = 0;

        for (int i = count - 1; i < games.size(); i++) {
            if(indexGameInRow % count != 0 || indexGameInRow == 0) {
                group.add(games.get(i));
            } else {
                indexGameInRow = 0;
                gameGroups.add(group);
                group = new ArrayList();
                group.add(games.get(i));
            }

            if(i == games.size() - 1)
                gameGroups.add(group);

            indexGameInRow++;
        }

        return gameGroups;
    }

    @Transactional
    public List<GameModel> getGamesByPattern(String pattern) {
        List<GameModel> resultGamesList = new ArrayList();

        for (GameModel game : getGames()) {
            if(game.getName().toUpperCase().contains(pattern.toUpperCase())) {
                resultGamesList.add(game);
            }
        }

        return resultGamesList;
    }

    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }
}
