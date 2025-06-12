package com.example.R2.controller;

import com.example.R2.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
public String register(
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam String fullName,
        @RequestParam String phone,
        HttpSession session,
        Model model
) {
    try {
        Map<String, Object> user = authService.register(email, password, fullName, phone);
        session.setAttribute("user", user);
        return "redirect:/";  // redireciona pra home da loja
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("error", "Erro ao cadastrar. Tente novamente.");
        return "register";
    }
    }
}
