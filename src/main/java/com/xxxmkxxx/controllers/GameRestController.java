package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.messages.Message;
import com.xxxmkxxx.common.wrappers.*;
import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.*;
import com.xxxmkxxx.services.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/ajax/game")
public class GameRestController {
    private PartyService partyService;
    private GameCommentsService gameCommentsService;
    private UserService userService;
    private PartyMembersService partyMembersService;
    private GameService gameService;

    @PostMapping("/party/search")
    public Message searchParty(String searchPattern, int gameId) {
        GameModel game = gameService.getGame(gameId);
        List<PartyModel> foundedParties = partyService.getPartiesByPattern(searchPattern, gameService.initParties(game));
        List<List<PartyModelWrapper>> groupedParties = partyService.groupPartiesWrapper(PartiesConfig.COUNT_PARTIES_ON_ROW, foundedParties);
        Message<PartyModelWrapper> message = new Message(
                "success",
                groupedParties
        );

        return message;
    }

    @PostMapping("/party/get")
    public Message getParty(@RequestParam("partyId") int partyId) {
        WrapperManager<PartyModelWrapper, PartyModel> wrapperManager = new WrapperManager(new PartyModelWrapper());
        PartyModel party = partyService.getParty(partyId);

        Message<PartyModelWrapper> message = new Message(
                "success",
                new PartyModelWrapper(partyMembersService.initializePartyMembers(party))
        );

        return message;
    }

    @PostMapping("/party/create")
    public Message createParty(
            @RequestParam("privacy") boolean privacy,
            @RequestParam("password") String password,
            @RequestParam("countPlayers") int countPlayers,
            @RequestParam("description") String description,
            @RequestParam("gameId") int gameId,
            HttpSession session) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        Message<List<UserModelWrapper>> message = new Message(
                "success",
                null
        );

        if(user.getPartyMember() == null) {
            PartyModel party = partyService.createParty(privacy, password, countPlayers, description, gameId);
            partyMembersService.addPartyMember("создатель", user, party);
        }
        else {
            System.err.println("Невозможно быть владельцем нескольких пати!");
        }

        return message;
    }

    @GetMapping("/party/filters")
    public Message useFilters(String filterStatus, int amountPlayers, int gameId) {
        GameModel game = gameService.getGame(gameId);
        List<PartyModel> foundedParties = partyService.getPartiesByFilters(filterStatus, amountPlayers, gameService.initParties(game));

        System.err.println(foundedParties.size());

        Message<List<PartyModelWrapper>> message = new Message(
                "success",
                partyService.groupPartiesWrapper(PartiesConfig.COUNT_PARTIES_ON_ROW, foundedParties)
        );

        return message;
    }

    @PostMapping("/comments/more")
    public Message getMoreGameComments(int lastCommentId, int gameId) {
        GameModel game = gameService.getGame(gameId);
        List<GameCommentModelWrapper> comments = gameCommentsService.getPartCommentsWrapper(lastCommentId, gameService.initComments(game));
        Message message = new Message("success", comments);

        return message;
    }

    @PostMapping("/comments/update")
    public Message getGameComments(@RequestParam("gameId") int gameId) {
        GameModel game = gameService.getGame(gameId);
        List<GameCommentModelWrapper> comments = gameCommentsService.getPartCommentsWrapper(
                0,
                gameService.initComments(game)
        );
        Message message = new Message("success", comments);

        return message;
    }

    @PostMapping("/comments/create")
    public Message createGameComment(int gameId, String text, HttpSession session) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        GameModel game = gameService.getGame(gameId);
        GameCommentModel comment = new GameCommentModel(game, text, user);
        String statusMessage = (
                gameService.addComment(game, comment).equals(gameCommentsService.addComment(comment))
                        ? "success"
                        : "error"
        );
        Message<Object> message = new Message(
                statusMessage,
                null
        );

        return message;
    }

    @PostMapping("/popular/review")
    public Message createReview(int review) {
        return new Message(
                "success",
                "Спасибо за оценку!"
        );
    }

    @PostMapping("/popular/get")
    public Message getPop(int gameId) {
        int pop = gameService.getGame(gameId).getPopularity();

        return new Message(
                "success",
                pop
        );
    }


    public GameRestController(PartyService partyService, GameCommentsService gameCommentsService, UserService userService, PartyMembersService partyMembersService, GameService gameService) {
        this.partyService = partyService;
        this.gameCommentsService = gameCommentsService;
        this.userService = userService;
        this.partyMembersService = partyMembersService;
        this.gameService = gameService;
    }
}
