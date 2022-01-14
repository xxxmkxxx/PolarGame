package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.wrappers.UserModelWrapper;
import com.xxxmkxxx.models.UserModel;
import com.xxxmkxxx.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @PostMapping("/friends/remove")
    public String removeFriend(@RequestParam("friendLogin") String friendLogin, HttpSession session) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        UserModel friend = userService.getUserByLogin(friendLogin);

        userService.removeFriend(user, friend);

        return "success";
    }

    @PostMapping("/friends/get")
    public List<UserModelWrapper> getFriends(HttpSession session) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

        return userService.getFriendsWrappers(user);
    }

    public UsersRestController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }
}
