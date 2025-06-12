package com.example.R2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final WebClient webClient;

    public AuthService(WebClient webClient) {
        this.webClient = webClient;
    }

   public Map<String, Object> register(String email, String password, String fullName, String phone) {
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("email", email);
    requestBody.put("password", password);

    Map<String, String> userMetadata = new HashMap<>();
    userMetadata.put("full_name", fullName);
    userMetadata.put("phone", phone);
    requestBody.put("data", userMetadata);

    try {
        return webClient.post()
                .uri("/signup")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    } catch (Exception e) {
        System.err.println("❌ ERRO AO REGISTRAR USUÁRIO:");
        e.printStackTrace();  // mostra a causa exata
        throw new RuntimeException("Erro ao registrar usuário no Supabase: " + e.getMessage());
    }
}


    public Map<String, Object> login(String email, String password) {
    Map<String, String> body = new HashMap<>();
    body.put("email", email);
    body.put("password", password);

    try {
        return webClient.post()
                .uri("/token?grant_type=password")
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    } catch (Exception e) {
        throw new RuntimeException("Erro ao fazer login: " + e.getMessage());
    }
}

}
