package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GamesController {
    @GetMapping()
    public String gamePage() {
        return "gamePage";
    }
}
