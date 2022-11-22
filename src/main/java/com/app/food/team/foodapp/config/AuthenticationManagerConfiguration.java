//package com.app.food.team.foodapp.config;
//
//import com.app.food.team.foodapp.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import static java.lang.String.format;
//
//@Configuration
//@AllArgsConstructor
//public class AuthenticationManagerConfiguration {
//    UserRepository userRepository;
//    DaoAuthenticationProvider daoAuthenticationProvider;
//
//    @Bean
//    public AuthenticationManager getAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//        return new AuthenticationManager() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                return authentication;
//            }
//        };
//    }
//
////    @Bean
////    public AuthenticationManager getAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .authenticationProvider(daoAuthenticationProvider)
////                .userDetailsService(email -> userRepository
////                .findByEmail(email)
////                .orElseThrow(
////                        () -> new UsernameNotFoundException(format("User: %s, not found", email))
////                ));
////        return auth.build();
////    }
//}
