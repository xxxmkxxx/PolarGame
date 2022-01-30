package com.xxxmkxxx.services;

import com.xxxmkxxx.common.sorting.SortingGamesByPopularityComparator;
import com.xxxmkxxx.common.wrappers.GameModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.dao.GameDAOImpl;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.TeamModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameService {
    private GameDAOImpl dao;

    public GameService(GameDAOImpl dao) {
        this.dao = dao;
    }

    @Transactional
    public GameModel getGame(int gameId) {
        return dao.read(gameId);
    }

    @Transactional
    public List<GameModel> getGames() {
        return dao.read();
    }

    @Transactional
    public List<GameModel> getSortedGamesByPopularity(List<GameModel> games) {
        List<GameModel> sortedGames = games;
        SortingGamesByPopularityComparator comparator = new SortingGamesByPopularityComparator();

        Collections.sort(sortedGames, comparator);

        return sortedGames;
    }

    @Transactional
    public List<GameModelWrapper> getSortedGamesByPopularityWrapper(List<GameModel> games) {
        WrapperManager<GameModelWrapper, GameModel> wrapperManager = new WrapperManager(new GameModelWrapper());

        return wrapperManager.convertList(getSortedGamesByPopularity(games));
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

        resultGamesList =
                getGames()
                .stream()
                .filter(game -> game.getName().toUpperCase().contains(pattern.toUpperCase()))
                .collect(Collectors.toList());

        return resultGamesList;
    }

    @Transactional
    public List<GameModelWrapper> getGamesByPatternWrapper(String pattern) {
        List<GameModel> foundGames = getGamesByPattern(pattern);
        WrapperManager<GameModelWrapper, GameModel> wrapperManager = new WrapperManager(new GameModelWrapper());

        return wrapperManager.convertList(foundGames);
    }

    @Transactional
    public List<GameModel> getGamesByFilters(List<String> filters) {
        List<GameModel> games = getGames();
        List<GameModel> result = new ArrayList();

        for(String filter : filters) {
            result.addAll(games.stream().filter(game -> {
                return game.getGenres()
                        .stream()
                        .allMatch(genre -> {
                            String temp[] = filter.split("_");
                            boolean tempB = genre.getGenreId() == Integer.parseInt(temp[temp.length - 1]);

                            return tempB;
                        });
            }).collect(Collectors.toList()));
        }

        return result;
    }

    @Transactional
    public String addComment(GameModel game, GameCommentModel comment) {
        dao.initializeComments(game).getComments().add(comment);
        dao.update(game);

        return "success";
    }

    @Transactional
    public List<PartyModel> initParties(GameModel game) {
        return dao.initializeParties(game).getParties();
    }

    @Transactional
    public List<GameCommentModel> initComments(GameModel game) {
        return dao.initializeComments(game).getComments();
    }

    @Transactional
    public List<TeamModel> getTeams(GameModel game) {
        return dao.initializeTeams(game).getTeams();
    }
}
