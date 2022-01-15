package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.services.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {
    private GameService gameService;
    private GameCommentsService gameCommentsService;
    private PartyService partyService;
    private PartyMembersService partyMembersService;
    private UserService userService;

    @GetMapping("/{id}")
    public String gamePage(@PathVariable("id") int id, Model model, HttpSession session) {
        String view = "/games/gamePage";

        GameModel game = gameService.getGame(id);
        int gameId = game.getGameId();
        List<GameCommentModel> comments = gameCommentsService.getComments(game);

        model.addAttribute("game", game);
        model.addAttribute("gameComments", gameCommentsService.getPartComments(0, comments));
        model.addAttribute("partyGroups", partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, partyService.getParties(gameId)));
        model.addAttribute("partyMembersService", partyMembersService);
        model.addAttribute("countAllComments", comments.size());

        if(session.getAttribute("userLogin") != null) {
            model.addAttribute("user", userService.getUserByLogin((String) session.getAttribute("userLogin")));
        } else {
            view = "redirect:/user/login";
        }

        return view;
    }

    public GameController(GameService gameService, GameCommentsService gameCommentsService, PartyService partyService, PartyMembersService partyMembersService, UserService userService) {
        this.gameService = gameService;
        this.gameCommentsService = gameCommentsService;
        this.partyService = partyService;
        this.partyMembersService = partyMembersService;
        this.userService = userService;
    }
}
