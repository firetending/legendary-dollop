package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.LoginRequestDto;
import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.dto.UserViewDto;
import com.app.food.team.foodapp.model.User;
import com.app.food.team.foodapp.service.JwtTokenService;
import com.app.food.team.foodapp.service.RegistrationService;
import com.app.food.team.foodapp.service.UserService;
//import com.app.food.team.foodapp.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("${request.mapping}")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private final JwtTokenService jwtTokenService;
    private final RegistrationService registrationService;

    @GetMapping(path = "ping")
    public ResponseEntity<ResponseDto> ping(){
        log.info("[UserController] ----> ping");
        return ResponseEntity.ok( // we can use .created here
            ResponseDto.builder()
                .timeStamp(now())
                .message("Service is up")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("token")
    public String token(@RequestBody @Valid LoginRequestDto loginRequestDto, Authentication authentication){
        log.info("Token requested for user: {}", authentication.getName());
        String token = jwtTokenService.generateJwtToken(authentication);
        log.info("Token granted {}", token);
        return token;
    }

    @GetMapping(path = "auth/logout")
    public ResponseEntity<ResponseDto> logout(HttpSession session){
        log.info("[UserController] ----> auth/logout");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object userResponse = getUserResponse(auth.getName());
        session.invalidate();

        return ResponseEntity.ok(
            ResponseDto.builder()
                .timeStamp(now())
                .message("Good bye!")
                .status(OK)
                .statusCode(OK.value())
                .data(new HashMap<>(){{
                    put("user", userResponse);
                }})
                .build()
        );
    }


    @PostMapping(path = "registration/register")
    public ResponseEntity<ResponseDto> register(@RequestBody @Valid RegistrationRequestDto registrationRequestDto, Errors errors) {
        log.info("[UserController] ----> /registration/register");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();

        try {
            registrationService.registrationRequestVerification(registrationRequestDto, errors);
            String token = registrationService.register(registrationRequestDto);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = getUserResponse(auth.getName());
            responseDtoBuilder
                .timeStamp(now())
                .message("User Registration was successful.")
                .status(OK)
                .statusCode(OK.value())
                .data(new HashMap<>(){{
                    put("user", userResponse);
                    put("confirmationToken", token);
                }})
                .build();

        } catch(IllegalStateException ise){
            responseDtoBuilder
                .timeStamp(now())
                .message("Registration attempt failed.")
                .status(HttpStatus.CONFLICT)
                .statusCode(HttpStatus.CONFLICT.value())
                .reason(ise.getMessage())
                .data(new HashMap<>(){{
                    put("errors", errors.getAllErrors());
                }});
        }

        return ResponseEntity.ok(
            responseDtoBuilder.build()
        );
    }

    @GetMapping(path = "registration/confirm")
    public ResponseEntity<ResponseDto> confirm(@RequestParam("token") String token) {
        log.info("[UserController] ----> registration/confirm");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();

        try {
            registrationService.confirmToken(token);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = getUserResponse(auth.getName());
            responseDtoBuilder
                .timeStamp(now())
                .message("User Confirmation was Successful.")
                .status(OK)
                .statusCode(OK.value())
                .data(new HashMap<>(){{
                    put("user", auth.getName());

                }})
                .build();

        } catch(IllegalStateException ise) {
            responseDtoBuilder
                .timeStamp(now())
                .message("Confirmation attempt failed.")
                .status(HttpStatus.CONFLICT)
                .statusCode(HttpStatus.CONFLICT.value())
                .reason(ise.getMessage());
        }

        return ResponseEntity.ok(
                responseDtoBuilder.build()
        );

    }




    // -------------------------------------------------------
    // Data controllers (they should be in another file or files)
    @GetMapping(path = "user/data")
    public ResponseEntity<ResponseDto> userData(Authentication authentication){
        log.info("[UserController] ----> user/data");

        Object userResponse = getUserResponse(authentication.getName());
        return ResponseEntity.ok(
                ResponseDto.builder()
                        .timeStamp(now())
                        .message("There you go!")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(new HashMap<>(){{
                            put("user", userResponse);
                            put("token", ((JwtAuthenticationToken) authentication).getToken().getTokenValue());
                        }})
                        .build()
        );
    }


    @GetMapping(path = "/admin/data")
    public ResponseEntity<ResponseDto> adminData(Authentication authentication){
        log.info("[UserController] ----> admin/data");

        Object userResponse = getUserResponse(authentication.getName());
        return ResponseEntity.ok(
                ResponseDto.builder()
                        .timeStamp(now())
                        .message("There you go!")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(new HashMap<>(){{
                            put("user", userResponse);
                            put("token", ((JwtAuthenticationToken) authentication).getToken().getTokenValue());
                        }})
                        .build()
        );
    }


    // put this in a service
    private Object getUserResponse(String username){
        return  userService.userExists(username)?
                    UserViewDto.createFromUser((User) userService.loadUserByUsername(username))
                    : username;
    }

}


