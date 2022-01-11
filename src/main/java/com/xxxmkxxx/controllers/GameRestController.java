package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.GameCommentsService;
import com.xxxmkxxx.services.PartyMembersService;
import com.xxxmkxxx.services.PartyService;
import com.xxxmkxxx.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ajax/game")
public class GameRestController {
    private PartyService partyService;
    private GameCommentsService gameCommentsService;
    private UserService userService;
    private PartyMembersService partyMembersService;

    @PostMapping("/party/search")
    public List<List<PartyModel>> searchParty(String searchPattern, int gameId) {
        List<PartyModel> foundedParties = partyService.getPartiesByPattern(searchPattern, gameId);
        List<List<PartyModel>> groupedParties = partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, foundedParties);

        return groupedParties;
    }

    @PostMapping("/party/create")
    public void createParty(
            @RequestParam("privacy") boolean privacy,
            @RequestParam("password") String password,
            @RequestParam("countPlayers") int countPlayers,
            @RequestParam("description") String description,
            @RequestParam("gameId") int gameId,
            HttpSession session) {

        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

        if(user.getPartyMember() == null) {
            PartyModel party = partyService.createParty(privacy, password, countPlayers, description, gameId);
            partyMembersService.addPartyMember("создатель", user, party);
        }
        else {
            System.err.println("Невозможно быть владельцем нескольких пати!");
        }
    }

    @GetMapping("/party/filters")
    public List<List<PartyModel>> useFilters(String filterStatus, int amountPlayers, int gameId) {
        List<PartyModel> foundedParties = partyService.getPartiesByFilters(filterStatus, amountPlayers, gameId);
        List<List<PartyModel>> groupedParties = partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, foundedParties);

        return groupedParties;
    }

    @PostMapping("/comments/more")
    public List<GameCommentModel> getMoreGameComments(int lastCommentId, int gameId) {
        return gameCommentsService.getMoreComments(lastCommentId, gameId);
    }

    @PostMapping("/comments/create")
    public String createGameComment(int gameId, String text, HttpSession session) {
        String message = gameCommentsService.validateComment(text);
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

        if(message.equals("success"))
            gameCommentsService.saveComment(gameId, text, user);

        return message;
    }


    public GameRestController(PartyService partyService, GameCommentsService gameCommentsService, UserService userService, PartyMembersService partyMembersService) {
        this.partyService = partyService;
        this.gameCommentsService = gameCommentsService;
        this.userService = userService;
        this.partyMembersService = partyMembersService;
    }
}
