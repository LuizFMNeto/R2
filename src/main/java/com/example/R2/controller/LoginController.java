package com.example.R2.controller;

import com.example.R2.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

@PostMapping("/login")
public String login(
    @RequestParam String email,
    @RequestParam String password,  // <-- Corrigido
    HttpSession session,
    Model model
) {
    try {
        Map<String, Object> user = authService.login(email, password);
        session.setAttribute("user", user);
        return "redirect:/dashboard";
    } catch (Exception e) {
        model.addAttribute("error", "Email ou senha inválidos");
        return "login";
    }
}


    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        // Tentativa de extrair o email do campo "user" na resposta
        Map<String, Object> userInfo = (Map<String, Object>) user.get("user");
        String email = userInfo != null ? (String) userInfo.get("email") : "Usuário";

        model.addAttribute("email", email);
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
