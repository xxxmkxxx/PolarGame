package com.xxxmkxxx.services;

import com.xxxmkxxx.common.sorting.SortingGamesByPopularityComparator;
import com.xxxmkxxx.common.wrappers.GameCommentModelWrapper;
import com.xxxmkxxx.common.wrappers.GameModelWrapper;
import com.xxxmkxxx.common.wrappers.Wrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.dao.TeamDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.TeamModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameService {
    private TeamDAO teamDAO;
    private GameDAO gameDAO;
    private GameCommentDAO gameCommentDAO;

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
    public List<GameModelWrapper> getSortedGamesByPopularityWrapper(List<GameModel> games) {
        List<GameModel> sortedGames = games;
        SortingGamesByPopularityComparator comparator = new SortingGamesByPopularityComparator();
        Wrapper<GameModelWrapper, GameModel> wrapper = new GameModelWrapper();

        Collections.sort(sortedGames, comparator);

        return wrapper.convertList(sortedGames);
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

        return resultGamesList;
    }

    @Transactional
    public List<GameModelWrapper> getGamesByPatternWrapper(String pattern) {
        List<GameModel> foundGames = getGamesByPattern(pattern);
        Wrapper<GameModelWrapper, GameModel> wrapper = new GameModelWrapper();

        return wrapper.convertList(foundGames);
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
        gameCommentDAO.saveComment(comment);

        gameDAO.initializeComments(game).getComments().add(comment);
        gameDAO.updateGame(game);

        return "success";
    }

    @Transactional
    public List<TeamModel> getTeams(GameModel game) {
        List<TeamModel> teams = gameDAO.initializeTeams(game).getTeams();

        for (int i = 0; i < teams.size(); i++) {
            teamDAO.initializeMembers(teams.get(i));
        }

        return teams;
    }


    public GameService(TeamDAO teamDAO, GameDAO gameDAO, GameCommentDAO gameCommentDAO) {
        this.teamDAO = teamDAO;
        this.gameDAO = gameDAO;
        this.gameCommentDAO = gameCommentDAO;
    }
}
