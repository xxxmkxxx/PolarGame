package com.xxxmkxxx.controllers.websockets;

import com.xxxmkxxx.common.messages.Message;
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
    public Message greeting(Message<Integer> socketMessage) {
        List<PartyModel> parties = partyService.getParties(socketMessage.getObject());

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
