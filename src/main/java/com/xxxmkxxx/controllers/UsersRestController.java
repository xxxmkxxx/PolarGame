package com.xxxmkxxx.controllers;

import com.xxxmkxxx.common.messages.Message;
import com.xxxmkxxx.common.wrappers.UserModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
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
    public Message validateRegistrationData(
            String login,
            String reg_form_mail,
            String reg_form_password,
            String reg_form_password2
    ) {
        String statusMessage = userService.validateRegistrationData(login, reg_form_mail, reg_form_password, reg_form_password2);
        Message message = new Message(statusMessage, null);

        if(statusMessage.equals("success")) {
            session.setAttribute("userLogin", login);
            session.setMaxInactiveInterval(10 * 60);
        }

        return message;
    }

    @PostMapping("/validateSingInData")
    public Message validateSingInData(String login, String password) {
        String statusMessage = userService.authentication(login, password);
        Message message = new Message(statusMessage, null);

        if(statusMessage.equals("success")) {
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

    @PostMapping("/update/description")
    public String updateDescription(@RequestParam("description") String description, HttpSession session) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

        userService.updateDescription(user, description);

        return "success";
    }

    @PostMapping("/update/data")
    public Message updateData(
            @RequestParam("newLogin") String newLogin,
            @RequestParam("lostPassword") String lostPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("repeatPassword") String repeatPassword,
            HttpSession session
    ) {
        UserModel user = userService.getUserByLogin((String) session.getAttribute("userLogin"));

        String message = userService.updateData(user, newLogin, lostPassword, newPassword, repeatPassword);
        Message<UserModelWrapper> mess;

        if(message.equals("success")) {
            session.setAttribute("userLogin", newLogin);
            mess = new Message(message, WrapperManager.convertUserModel(user));
        } else
            mess = new Message(message, null);

        return mess;
    }

    public UsersRestController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }
}
