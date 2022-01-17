package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.messages.Message;
import com.xxxmkxxx.common.wrappers.TeamMessageModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.TeamMessageService;
import com.xxxmkxxx.services.TeamService;
import com.xxxmkxxx.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/ajax/dialogs")
public class DialogsRestController {
    private TeamService teamService;
    private TeamMessageService teamMessageService;
    private UserService userService;

    @PostMapping("/team/message/create")
    public Message createTeamMessage(
            @RequestParam("text") String text,
            @RequestParam("teamId") int teamId,
            HttpSession session
    ) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        TeamModel team = teamService.getTeam(teamId);
        TeamMessageModel teamMessage = teamMessageService.createTeamMessage(text, user, team);

        Message<TeamMessageModelWrapper> message = new Message(
                "success",
                new TeamMessageModelWrapper(teamMessage)
        );

        return message;
    }

    @PostMapping("/team/get")
    public Message getTeamMessages(@RequestParam("teamId") int teamId) {
        TeamModel team = teamService.getTeam(teamId);
        List<TeamMessageModel> messages = teamMessageService.getMessages(team);
        WrapperManager<TeamMessageModelWrapper, TeamMessageModel> wrapperManager = new WrapperManager(new TeamMessageModelWrapper());

        Message<List<TeamMessageModelWrapper>> message = new Message(
                "success",
                wrapperManager.convertList(messages)
        );

        return message;
    }

    @PostMapping("/friends/message/create")
    public Message createFriendMessage(String text, int friendId) {


        return null;
    }

    public DialogsRestController(TeamService teamService, TeamMessageService teamMessageService, UserService userService) {
        this.teamService = teamService;
        this.teamMessageService = teamMessageService;
        this.userService = userService;
    }
}
