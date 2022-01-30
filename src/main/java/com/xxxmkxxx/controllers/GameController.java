package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.*;
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
    private TeamService teamService;

    @GetMapping("/{id}")
    public String gamePage(@PathVariable("id") int id, Model model, HttpSession session) {
        String view = "/games/gamePage";
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
            GameModel game = gameService.getGame(id);
            List<TeamModel> teams = gameService.getTeams(game);
            List<GameCommentModel> comments = gameService.initComments(game);

            model.addAttribute("authorized", true);
            model.addAttribute("user", user);
            model.addAttribute("game", game);
            model.addAttribute("teamsGroups", teamService.groupTeams(PartiesConfig.COUNT_PARTIES_ON_ROW, teams));
            model.addAttribute("gameComments", gameCommentsService.getPartComments(0, comments));
            model.addAttribute("partyGroups", partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, gameService.initParties(game)));
            model.addAttribute("partyMembersService", partyMembersService);
            model.addAttribute("countAllComments", comments.size());
        } else {
            return "redirect:/user/login";
        }

        return view;
    }

    public GameController(GameService gameService, GameCommentsService gameCommentsService, PartyService partyService, PartyMembersService partyMembersService, UserService userService, TeamService teamService) {
        this.gameService = gameService;
        this.gameCommentsService = gameCommentsService;
        this.partyService = partyService;
        this.partyMembersService = partyMembersService;
        this.userService = userService;
        this.teamService = teamService;
    }
}
