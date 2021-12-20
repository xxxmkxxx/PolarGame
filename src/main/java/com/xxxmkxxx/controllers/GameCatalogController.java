package com.xxxmkxxx.controllers;

import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class GameCatalogController {
    private GameService gameService;

    @GetMapping("")
    public String gameCatalogPage(Model model) {
        List<GameModel> games = gameService.getGames();
        List<GameModel> sortedGames = gameService.getSortedGamesByPopularity(games);

        model.addAttribute("sortedGames", gameService.groupGames(6, sortedGames));
        model.addAttribute("popularGames", gameService.getPopularGames(5, sortedGames));

        return "gameCatalogPage";
    }

    @PostMapping("/openGamePage")
    @ResponseBody
    public String openGamePage(@RequestBody String id) {
        return "redirect:/game/" + id;
    }

    public GameCatalogController(GameService gameService) {
        this.gameService = gameService;
    }
}
