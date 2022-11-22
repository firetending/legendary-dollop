package com.app.food.team.foodapp.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    private PasswordEncoder bCryptPasswordEncoder;
    private UserDetailsService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        String requestMapping = "/api/v1/";
        http
            .authenticationProvider(daoAuthenticationProvider())
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

    @Bean
    protected AuthenticationManager getAuthenticationManager(AuthenticationManager auth) throws Exception {
        return auth;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
