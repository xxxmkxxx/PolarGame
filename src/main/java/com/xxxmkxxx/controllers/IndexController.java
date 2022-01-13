package com.xxxmkxxx.controllers;

import com.xxxmkxxx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class IndexController {
    private UserService userService;

    @GetMapping()
    public String indexPage(Model model, HttpSession session) {
        boolean isAuthorized = session.getAttribute("userLogin") == null ? false : true;

        if(isAuthorized)
            model.addAttribute("user", userService.getUserByLogin((String) session.getAttribute("userLogin")));

        model.addAttribute("pageName", "главная страница".toUpperCase(Locale.ROOT));
        model.addAttribute("authorized", isAuthorized);

        return "indexPage";
    }

    public IndexController(UserService userService) {
        this.userService = userService;
    }
}
