package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.messages.Message;
import com.xxxmkxxx.common.wrappers.GameModelWrapper;
import com.xxxmkxxx.common.wrappers.GenresModelWrapper;
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
    public Message searchGame(@RequestParam("searchPattern") String searchPattern) {
        Message<GameModelWrapper> message = new Message(
                "success",
                gameService.getGamesByPatternWrapper(searchPattern)
        );

        return message;
    }

    @PostMapping("/get/genres")
    public Message getGenres() {
        Message<GenresModelWrapper> message = new Message("success", genresService.getGenresWrapper());

        return message;
    }

    @PostMapping("/filters")
    public Message useFilters(@RequestParam(value="genresId[]") List<String> genresId) {
        List<GameModel> filteredGames = gameService.getGamesByFilters(genresId);

        Message<GameModelWrapper> message = new Message(
                "success",
                gameService.getSortedGamesByPopularityWrapper(filteredGames)
        );


        return message;
    }

    public GameCatalogRestController(GameService gameService, GenresService genresService) {
        this.gameService = gameService;
        this.genresService = genresService;
    }
}
