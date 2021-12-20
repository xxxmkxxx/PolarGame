package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping()
    public String indexPage(Model model) {
        model.addAttribute("mail", "");

        return "indexPage";
    }
}
