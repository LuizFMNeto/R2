package com.example.R2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", ""})
    public String home() {
        return "home";  // Renderiza src/main/resources/templates/home.html
    }

    @GetMapping({"/carrinho", "/carrinho"})
    public String carrinho() {
        return "carrinho";  // Renderiza carrinho.html
    }
}
