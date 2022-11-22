package com.app.food.team.foodapp.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Value("${request.mapping}")
    private String requestMapping;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
//            .sessionManagement(session -> session
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            )
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                    requestMapping + "ping",
                    requestMapping + "auth/**",
                    requestMapping + "registration/**"
                ).permitAll()
                .requestMatchers(requestMapping + "admin/**").hasAuthority("ADMIN")
                .requestMatchers(requestMapping + "user/**").hasAuthority("USER")
                .anyRequest().denyAll()
            )
            .rememberMe(withDefaults())

            .userDetailsService(userService)
            .formLogin()
            //.httpBasic();
            ;

        return http.build();
    }



//    // For demo purposes when there is no users table
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user1@hello.com")
//                .password("password")
//                .roles("User")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}
