package com.xxxmkxxx.controllers;

import com.xxxmkxxx.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/ajax/user")
public class UsersRestController {
    private UserService userService;
    private HttpSession session;

    @PostMapping("/validateRegistrationData")
    public String validateRegistrationData(String login, String reg_form_mail, String reg_form_password, String reg_form_password2) {
        String message = userService.validateRegistrationData(login, reg_form_mail, reg_form_password, reg_form_password2);

        if(message.equals("success")) {
            session.setAttribute("userLogin", login);
            session.setMaxInactiveInterval(10 * 60);
        }

        return message;
    }

    @PostMapping("/validateSingInData")
    public String validateSingInData(String login, String password) {
        String message = userService.authentication(login, password);

        if(message.equals("success")) {
            session.setAttribute("userLogin", login);
            session.setMaxInactiveInterval(10 * 60);
        }

        return message;
    }

    public UsersRestController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }
}
