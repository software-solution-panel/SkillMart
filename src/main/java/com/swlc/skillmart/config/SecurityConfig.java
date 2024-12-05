package com.swlc.skillmart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Explicitly disabling CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/signin", "/api/v1/auth/login").permitAll() // Allow public access to specific endpoint
                        .requestMatchers("/api/v1/rate/**").permitAll()
                        .requestMatchers("/api/v1/user/**").permitAll()
                        .requestMatchers("/api/v1/serviceType/**").permitAll()
                        .requestMatchers("/api/v1/serviceArea/**").permitAll()
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                );
        return http.build();
    }
}
