package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.TeamService;
import com.xxxmkxxx.services.UserService;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/team")
public class TeamController {
    private UserService userService;
    private TeamService teamService;

    @GetMapping("/{id}")
    public String viewTeamPage(@PathVariable("id") int id, Model model, HttpSession session) {
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
            TeamModel team = teamService.getTeam(id);

            model.addAttribute("authorized", true);
            model.addAttribute("user", user);
            model.addAttribute("team", team);
        } else {
            return "redirect:/user/login";
        }

        return "/team";
    }

    public TeamController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }
}
