package com.xxxmkxxx.controllers;

import com.xxxmkxxx.services.UserService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ajax/user")
public class UsersRestController {
    private UserService userService;

    @PostMapping("/validateRegistrationData")
    public String validateRegistrationData(String login, String reg_form_mail, String reg_form_password, String reg_form_password2) {
        return userService.validateRegistrationData(login, reg_form_mail, reg_form_password, reg_form_password2);
    }

    @PostMapping("/validateSingInData")
    public String validateSingInData(String login, String password) {
        return userService.authentication(login, password);
    }

    public UsersRestController(UserService userService) {
        this.userService = userService;
    }
}
