package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.GenresModel;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.GenresService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax/catalog/games")
public class GameCatalogRestController {
    private GameService gameService;
    private GenresService genresService;

    @PostMapping("/redirect")
    public String transitionToGame(int gameId) {
        String message = "";

        if(gameId == 0 || gameService.getGame(gameId) == null)
            message = "Not found";

        return message;
    }

    @PostMapping("/search")
    public List<GameModel> searchGame(@RequestParam("searchPattern") String searchPattern) {
        return gameService.getGamesByPattern(searchPattern);
    }

    @PostMapping("/get/genres")
    public List<GenresModel> getGenres() {
        return genresService.getGenres();
    }

    @PostMapping("/filters")
    public List<GameModel> useFilters(@RequestParam(value="genresId[]") List<String> genresId) {
        List<GameModel> filteredGames = gameService.getGamesByFilters(genresId);
        List<GameModel> sortedGamesByPopularity = gameService.getSortedGamesByPopularity(filteredGames);

        return sortedGamesByPopularity;
    }

    public GameCatalogRestController(GameService gameService, GenresService genresService) {
        this.gameService = gameService;
        this.genresService = genresService;
    }
}
