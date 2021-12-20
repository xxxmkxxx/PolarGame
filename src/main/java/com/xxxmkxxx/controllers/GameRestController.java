package com.xxxmkxxx.controllers;

import com.xxxmkxxx.config.PartiesConfig;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.GameCommentsService;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.PartyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax/game")
public class GameRestController {
    private PartyService partyService;
    private GameCommentsService gameCommentsService;

    @PostMapping("/party/search")
    public List<List<PartyModel>> searchParty(String searchPattern, int gameId) {
        return partyService.groupParties(PartiesConfig.COUNT_PARTIES_ON_ROW, partyService.getPartiesByPattern(searchPattern, gameId));
    }

    @PostMapping("/comments/more")
    public List<GameCommentModel> getMoreGameComments(int lastCommentId, int gameId) {
        return gameCommentsService.getMoreComments(lastCommentId, gameId);
    }

    public GameRestController(PartyService partyService, GameCommentsService gameCommentsService) {
        this.partyService = partyService;
        this.gameCommentsService = gameCommentsService;
    }
}
