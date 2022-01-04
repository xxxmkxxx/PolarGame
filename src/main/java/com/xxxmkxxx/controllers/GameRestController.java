package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.GameCommentsService;
import com.xxxmkxxx.services.PartyService;
import com.xxxmkxxx.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ajax/game")
public class GameRestController {
    private PartyService partyService;
    private GameCommentsService gameCommentsService;
    private UserService userService;

    @PostMapping("/party/search")
    public List<List<PartyModel>> searchParty(String searchPattern, int gameId) {
        List<PartyModel> foundedParties = partyService.getPartiesByPattern(searchPattern, gameId);
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

    public GameRestController(PartyService partyService, GameCommentsService gameCommentsService, UserService userService) {
        this.partyService = partyService;
        this.gameCommentsService = gameCommentsService;
        this.userService = userService;
    }
}
