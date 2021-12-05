package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {

    @GetMapping("/login")
    public String authorizationPage() {
        return "/users/singInPage";
    }

    @GetMapping("/new")
    public String registrationPage() {
        return "/users/newUserPage";
    }

    @PostMapping("/new")
    public String index() {
        return "/users/newUserPage";
    }

    @PostMapping("/login")
    public String check() {
        return "/users/singInPage";
    }
}
