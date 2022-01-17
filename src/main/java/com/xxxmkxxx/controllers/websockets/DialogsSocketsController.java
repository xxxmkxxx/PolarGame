package com.xxxmkxxx.controllers.websockets;

import com.xxxmkxxx.common.messages.CreateNewPartyMessage;
import com.xxxmkxxx.common.messages.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class DialogsSocketsController {
    @MessageMapping("/parties")
    @SendTo("/topic/new/message")
    public Message creatingTeamMessage() {
        Message message = new Message(
                "success",
                null
        );

        return message;
    }
}
