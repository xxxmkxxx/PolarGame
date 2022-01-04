package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {
    @GetMapping("/login")
    public String viewAuthorizationPage() {
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
}
