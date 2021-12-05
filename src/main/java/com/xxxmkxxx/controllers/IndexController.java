package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping()
    public String indexPage(Model model) {
        model.addAttribute("tempUser", new Object());
        model.addAttribute("test", "fffffffffffffffffff");

        return "indexPage";
    }
}
