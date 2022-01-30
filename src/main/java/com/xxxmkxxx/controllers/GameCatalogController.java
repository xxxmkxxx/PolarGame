package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/catalog")
public class GameCatalogController {
    private GameService gameService;
    private UserService userService;

    @GetMapping("")
    public String gameCatalogPage(Model model, HttpSession session) {
        String view = "/games/gameCatalogPage";
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            List<GameModel> games = gameService.getGames();
            List<GameModel> sortedGames = gameService.getSortedGamesByPopularity(games);

            model.addAttribute("namePage", "каталог игр".toUpperCase(Locale.ROOT));
            model.addAttribute("authorized", true);
            model.addAttribute("user", userService.getUserByLogin((String) session.getAttribute("userLogin")));
            model.addAttribute("sortedGames", gameService.groupGames(6, sortedGames));
            model.addAttribute("popularGames", gameService.getPopularGames(5, sortedGames));
        } else {
            return "redirect:/user/login";
        }

        return view;
    }

    @PostMapping("/openGamePage")
    public String openGamePage(@RequestBody String id) {
        return "redirect:/game/" + id;
    }

    public GameCatalogController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }
}
