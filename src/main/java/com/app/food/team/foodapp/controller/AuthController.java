package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.LoginRequestDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.service.JwtTokenService;
import com.app.food.team.foodapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("${app.request-mapping}auth/")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<ResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto, Errors errors){
        log.info("[UserController] ----> auth/login");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();
        try {
            if (errors.hasErrors()) {
                throw new IllegalStateException("Login error");
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getEmail(),
                    loginRequestDto.getPassword()
            ));
            Object userResponse = userService.getUserResponse(authentication.getName());
            responseDtoBuilder
                    .timeStamp(now())
                    .message("Login was successful")
                    .status(OK)
                    .statusCode(OK.value())
                    .data(new HashMap<>() {{
                        put("user", userResponse);
                        put("accessToken", jwtTokenService.generateJwtToken(authentication));
                    }});

        } catch(IllegalStateException ie) {
            responseDtoBuilder
                    .timeStamp(now())
                    .message("Registration attempt failed.")
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .statusCode(HttpStatus.NOT_ACCEPTABLE.value())
                    .reason(ie.getMessage())
                    .data(new HashMap<>(){{
                        put("errors", "Bad credentials");
                    }});

        }
        return ResponseEntity.ok(
                responseDtoBuilder.build()
        );
    }

    /*
     * Logging out needs to be implemented
     */
    @PostMapping(path = "logout")
    public ResponseEntity<ResponseDto> logout(){
        log.info("[UserController] ----> auth/logout");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object userResponse = userService.getUserResponse(auth.getName());

        return ResponseEntity.ok(
            ResponseDto.builder()
                .timeStamp(now())
                .message("Nothing to look at here")
                .developerMessage("Not implemented")
                .status(NOT_IMPLEMENTED)
                .statusCode(NOT_IMPLEMENTED.value())
                .data(new HashMap<>(){{
                    put("user", userResponse);
                }})
                .build()
        );
    }

}
