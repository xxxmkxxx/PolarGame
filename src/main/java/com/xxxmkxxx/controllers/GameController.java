package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.dao.PartyDAO;
import com.xxxmkxxx.dao.PartyMemberDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.services.GameCommentsService;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.PartyMembersService;
import com.xxxmkxxx.services.PartyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/game")
public class GameController {
    private GameService gameService;
    private GameCommentsService gameCommentsService;
    private PartyService partyService;
    private PartyMembersService partyMembersService;

    @GetMapping("/{id}")
    public String gamePage(@PathVariable("id") int id, Model model) {
        GameModel game = gameService.getGame(id);
        int gameId = game.getGameId();
        List<GameCommentModel> comments = gameCommentsService.getComments(gameId);

        model.addAttribute("game", game);
        model.addAttribute("gameComments", gameCommentsService.getPartComments(0, comments));
        model.addAttribute("partyGroups", partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, partyService.getParties(gameId)));
        model.addAttribute("partyMembersService", partyMembersService);
        model.addAttribute("countAllComments", comments.size());

        return "gamePage";
    }

    public GameController(GameService gameService, GameCommentsService gameCommentsService, PartyService partyService, PartyMembersService partyMembersService) {
        this.gameService = gameService;
        this.gameCommentsService = gameCommentsService;
        this.partyService = partyService;
        this.partyMembersService = partyMembersService;
    }
}
