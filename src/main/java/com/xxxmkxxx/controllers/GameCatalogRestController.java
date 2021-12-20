package com.xxxmkxxx.controllers;

import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.services.GameService;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ajax/catalog/game")
public class GameCatalogRestController {
    private GameService gameService;

    @PostMapping("/redirect")
    public String transitionToGame(int gameId) {
        String message = "";

        if(gameId == 0 || gameService.getGame(gameId) == null)
            message = "Not found";

        return message;
    }

    @PostMapping("/search")
    public List<GameModel> searchGame(String searchPattern) {
        return gameService.getGamesByPattern(searchPattern);
    }

    public GameCatalogRestController(GameService gameService) {
        this.gameService = gameService;
    }
}
