package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UsersController {
    @GetMapping("/login")
    public String viewAuthorizationPage() {
        return "/users/singInPage";
    }

    @GetMapping("/new")
    public String viewRegistrationPage() {
        return "/users/newUserPage";
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
