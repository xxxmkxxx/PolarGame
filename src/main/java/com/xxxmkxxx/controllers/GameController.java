package com.xxxmkxxx.controllers;

import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.dao.PartyDAO;
import com.xxxmkxxx.dao.PartyMemberDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
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
    private GameDAO gameDAO;
    private GameCommentDAO gameCommentDAO;
    private PartyDAO partyDAO;
    private PartyMemberDAO partyMemberDAO;

    @GetMapping("/{id}")
    public String gamePage(@PathVariable("id") int id, Model model) {
        GameModel game = gameDAO.getGameById(id);
        int gameId = game.getGameId();
        List gameComments = gameCommentDAO.getAllComments(gameId);
        List<PartyModel> parties = partyDAO.getAllParties(gameId);
        List<PartyMemberModel> partiesMembers = partyMemberDAO.getAllMembers();

        model.addAttribute("game", game);
        model.addAttribute("gameComments", gameComments);
        model.addAttribute("partyGroups", PartyService.groupParties(3, parties));
        model.addAttribute("partyMemberDAO", partyMemberDAO);

        return "gamePage";
    }

    public GameController(GameDAO gameDAO, GameCommentDAO gameCommentDAO, PartyDAO partyDAO, PartyMemberDAO partyMemberDAO) {
        this.gameDAO = gameDAO;
        this.gameCommentDAO = gameCommentDAO;
        this.partyDAO = partyDAO;
        this.partyMemberDAO = partyMemberDAO;
    }
}
