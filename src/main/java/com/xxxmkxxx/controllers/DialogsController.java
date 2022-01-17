package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.GameService;
import com.xxxmkxxx.services.TeamMessageService;
import com.xxxmkxxx.services.TeamService;
import com.xxxmkxxx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dialogs")
public class DialogsController {
    private UserService userService;
    private TeamService teamService;
    private TeamMessageService teamMessageService;

    @GetMapping("/")
    public String viewDialogsPage(Model model, HttpSession session) {
        String view = "dialogs";

        if(session.getAttribute("userLogin") != null) {
            UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
            List<TeamModel> userTeams = teamService.getUserTeams(user);
            List<TeamMessageModel> teamMessages = teamMessageService.getMessages(userTeams.get(0));

            model.addAttribute("user", user);
            model.addAttribute("authorized", true);
            model.addAttribute("teams", userTeams);
            model.addAttribute("teamMessages", teamMessages);
            model.addAttribute("friendsDialogs", "");
        } else {
            view = "redirect:/user/login";
        }

        return view;
    }

    public DialogsController(UserService userService, TeamService teamService, TeamMessageService teamMessageService) {
        this.userService = userService;
        this.teamService = teamService;
        this.teamMessageService = teamMessageService;
    }
}
