package com.xxxmkxxx.controllers.websockets;

import com.xxxmkxxx.common.messages.CreateNewPartyMessage;
import com.xxxmkxxx.common.messages.Message;
import com.xxxmkxxx.common.wrappers.PartyModelWrapper;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyModel;
import com.xxxmkxxx.services.GameService;
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
    public Message greeting(CreateNewPartyMessage socketMessage) {
        List<PartyModel> parties = partyService.getParties(socketMessage.getGameId());
        Message message = new Message(
                "success",
                partyService.groupPartiesWrapper(3, parties)
        );

        return message;
    }

    public PartiesSocketsController(PartyService partyService) {
        this.partyService = partyService;
    }
}
