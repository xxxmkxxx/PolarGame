package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.messages.CreateNewPartyMessage;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.services.PartyService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartiesSocketsController {
    private PartyService partyService;

    @MessageMapping("/parties")
    @SendTo("/topic/new/party")
    public List<List<PartyModel>> greeting(CreateNewPartyMessage message) {
        return partyService.groupParties(3, partyService.getParties(message.getGameId()));
    }

    public PartiesSocketsController(PartyService partyService) {
        this.partyService = partyService;
    }
}
