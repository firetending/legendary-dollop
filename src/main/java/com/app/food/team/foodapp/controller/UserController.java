package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.RegistrationRequest;
import com.app.food.team.foodapp.dto.Response;
import com.app.food.team.foodapp.service.RegistrationService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private final RegistrationService registrationService;

    @GetMapping(path = "/ping")
    public ResponseEntity<Response> ping(){
        log.info("[UserController] ----> /ping");
        return ResponseEntity.ok( // we can use .created here
                Response.builder()
                        .timeStamp(now())
                        .message("Service is up")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/user/home")
    public String userHome(){
        log.info("[UserController] ----> /user/home");
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("<h1>Hi User %s!</h1>", currentUserName);
    }

    @GetMapping(path = "/admin/home")
    public String adminHome(){
        log.info("[UserController] ----> /admin/home");
        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("<h1>Hi Admin %s!</h1>", currentUserName);
    }

    @GetMapping(path = "/logout")
    public String logout(HttpSession session){
        log.info("[UserController] ----> /logout");
        session.invalidate();
        return "<h1>Good Bye!</h1>";
    }

    @PostMapping(path = "/registration/register")
    public String register(@RequestBody RegistrationRequest request, HttpSession session) {
        log.info("[UserController] ----> /registration/register");
        log.info("<h1>%s is confirmed!</h1>", session.getAttribute("name"));
        return registrationService.register(request);
    }

    @GetMapping(path = "/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        log.info("[UserController] ----> /registration/confirm");
        return registrationService.confirmToken(token);
    }

}


