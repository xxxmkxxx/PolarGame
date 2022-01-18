package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.TeamMemberModel;
import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.TeamMessageService;
import com.xxxmkxxx.services.TeamService;
import com.xxxmkxxx.services.UserService;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private UserService userService;
    private TeamService teamService;
    private TeamMessageService teamMessageService;

    @GetMapping("/{id}")
    public String viewTeamPage(@PathVariable("id") int id, Model model, HttpSession session) {
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
            TeamModel team = teamService.getTeam(id);
            List<TeamMessageModel> teamMessages = teamMessageService.getMessages(team);
            List<TeamMemberModel> members = teamService.initMembers(team).getMembers();

            model.addAttribute("authorized", true);
            model.addAttribute("user", user);
            model.addAttribute("team", team);
            model.addAttribute("members", members);
            model.addAttribute("teamMessages", teamMessages);
        } else {
            return "redirect:/user/login";
        }

        return "/team";
    }

    public TeamController(UserService userService, TeamService teamService, TeamMessageService teamMessageService) {
        this.userService = userService;
        this.teamService = teamService;
        this.teamMessageService = teamMessageService;
    }
}
