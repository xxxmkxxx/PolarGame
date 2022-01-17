package com.xxxmkxxx.controllers;

import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/user")
public class UsersController {
    private UserService userService;

    @GetMapping("/login")
    public String viewAuthorizationPage(Model model) {
        model.addAttribute("pageName", "авторизация".toUpperCase(Locale.ROOT));

        return "/users/singInPage";
    }

    @GetMapping("/new/{mail}")
    public String viewRegistrationPage(@PathVariable("mail") String mail, Model model) {
        String resultMail;

        if(mail == null || mail.equals("none"))
            resultMail = "";
        else
            resultMail = mail;

        model.addAttribute("mail", resultMail);

        return "/users/newUserPage";
    }

    @GetMapping("/new")
    public String viewRegistrationPage() {
        return "redirect:/user/new/none";
    }

    @PostMapping("/successfulRegistration")
    public String successfulRegistration() {
        return "redirect:/catalog";
    }

    @PostMapping("/successfulAuthentication")
    public String successfulAuthentication() {
        return "redirect:/catalog";
    }

    @GetMapping("/profile")
    public String viewMineProfilePage(Model model, HttpSession session) {
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

            model.addAttribute("authorized", true);
            model.addAttribute("myPage", true);
            model.addAttribute("pageName", "профиль".toUpperCase(Locale.ROOT));
            model.addAttribute("user", user);
            model.addAttribute("friends", userService.getFriends(user));
        } else {
            return "redirect:/user/login";
        }

        return "/users/profile";
    }

    @GetMapping("/profile/{nick}")
    public String viewAlienProfilePage(@PathVariable("nick") String login, Model model, HttpSession session) {
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized) {
            UserModel user = userService.getUserByLogin(login);

            model.addAttribute("authorized", true);
            model.addAttribute("myPage", false);
            model.addAttribute("pageName", "профиль".toUpperCase(Locale.ROOT));
            model.addAttribute("user", user);
            model.addAttribute("friends", userService.getFriends(user));
        } else {
            return "redirect:/user/login";
        }

        return "/users/profile";
    }

    @GetMapping("/out")
    public String singOutRedirect(HttpSession session) {
        session.removeAttribute("userLogin");
        session.invalidate();

        return "redirect:/user/login";
    }

    public UsersController(UserService userService) {
        this.userService = userService;
    }
}
