package com.example.R2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SupabaseConfig {

    @Bean
    public WebClient supabaseClient(
            @Value("${supabase.url}") String supabaseUrl,
            @Value("${supabase.key}") String supabaseKey) {

        return WebClient.builder()
                .baseUrl("https://cimpbfxhegdovpgoftmc.supabase.co" + "/auth/v1")
                .defaultHeader("apiKey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNpbXBiZnhoZWdkb3ZwZ29mdG1jIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDk1NjMwOTMsImV4cCI6MjA2NTEzOTA5M30.XpH8re7AC8Zzmnrhqv8NbLzowHr8zR_rkHudZ0A9v3I")
                .defaultHeader("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNpbXBiZnhoZWdkb3ZwZ29mdG1jIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDk1NjMwOTMsImV4cCI6MjA2NTEzOTA5M30.XpH8re7AC8Zzmnrhqv8NbLzowHr8zR_rkHudZ0A9v3I")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
