package com.xxxmkxxx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dialogs")
public class DialogsController {

    @GetMapping("/")
    public String indexPage() {
        return "dialogs";
    }

}
