package com.app.food.team.foodapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        String requestMapping = "/api/v1/";
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                requestMapping + "ping",
                                requestMapping + "auth/**",
                                requestMapping + "registration/**"
                        ).permitAll()
                        .requestMatchers(requestMapping + "admin/**").hasAuthority("ADMIN")
                        .requestMatchers(requestMapping + "user/**").hasAuthority("USER")
                        .anyRequest().denyAll()
                ).formLogin();
        return http.build();
    }
}
