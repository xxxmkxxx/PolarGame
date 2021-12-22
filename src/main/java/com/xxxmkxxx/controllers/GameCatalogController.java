package com.xxxmkxxx.controllers;

import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class GameCatalogController {
    private GameService gameService;
    private UserService userService;

    @GetMapping("")
    public String gameCatalogPage(Model model, HttpSession session) {
        String view = "gameCatalogPage";

        List<GameModel> games = gameService.getGames();
        List<GameModel> sortedGames = gameService.getSortedGamesByPopularity(games);

        model.addAttribute("sortedGames", gameService.groupGames(6, sortedGames));
        model.addAttribute("popularGames", gameService.getPopularGames(5, sortedGames));

        if(session.getAttribute("userLogin") != null) {
            model.addAttribute("user", userService.getUserByLogin((String) session.getAttribute("userLogin")));
        } else {
            view = "redirect:/user/login";
        }

        return view;
    }

    @PostMapping("/openGamePage")
    @ResponseBody
    public String openGamePage(@RequestBody String id) {
        return "redirect:/game/" + id;
    }

    public GameCatalogController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }
}
