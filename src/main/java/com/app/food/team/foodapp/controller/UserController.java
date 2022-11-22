package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.AuthCredentialsRequestDto;
import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.dto.UserDisplayDto;
import com.app.food.team.foodapp.model.User;
import com.app.food.team.foodapp.repository.UserRepository;
import com.app.food.team.foodapp.service.RegistrationService;
import com.app.food.team.foodapp.service.UserService;
//import com.app.food.team.foodapp.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private final RegistrationService registrationService;
    //private final AuthenticationManager authenticationManager;
    //private final JwtUtil jwtUtil;

    @GetMapping(path = "/ping")
    public ResponseEntity<ResponseDto> ping(){
        log.info("[UserController] ----> /ping");
        return ResponseEntity.ok( // we can use .created here
            ResponseDto.builder()
                .timeStamp(now())
                .message("Service is up")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

//    @PostMapping(path = "/auth/login")
//    public ResponseEntity<ResponseDto> login(@RequestBody @Valid AuthCredentialsRequestDto authCredentialsRequestDto){
//        log.info("[UserController] ----> /auth/login");
//        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object userResponse = getUserResponse(auth.getPrincipal());
//
//        try {
//            Authentication authenticate = authenticationManager
//                    .authenticate(
//                            new UsernamePasswordAuthenticationToken(
//                                    authCredentialsRequestDto.getUsername(),
//                                    authCredentialsRequestDto.getPassword()
//                            )
//                    );
//
//            User user =  (User) userService.loadUserByUsername(authenticate.getPrincipal().toString()); //(User) authenticate.getPrincipal();
//
//            return ResponseEntity.ok()
//                    .header(
//                        HttpHeaders.AUTHORIZATION,
//                        jwtUtil.generateAccessToken(user)
//                    )
//                    .body(
//                        ResponseDto.builder()
//                            .timeStamp(now())
//                            .message("Login was successful.")
//                            .status(OK)
//                            .statusCode(OK.value())
//                            .data(new HashMap<>(){{
//                                put("user", userResponse);
//                                put("isAuthenticated", auth.isAuthenticated());
//                            }})
//                            .build()
//                    );
//        } catch (BadCredentialsException ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(
//                        ResponseDto.builder()
//                            .timeStamp(now())
//                            .message("Login attempt failed.")
//                            .status(HttpStatus.UNAUTHORIZED)
//                            .statusCode(HttpStatus.UNAUTHORIZED.value())
//                            .reason(ex.getMessage())
//                            .build()
//                    );
//
//        }
//
//
//    }



    @GetMapping(path = "/auth/logout")
    public ResponseEntity<ResponseDto> logout(HttpSession session){
        log.info("[UserController] ----> /auth/logout");

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object userResponse = getUserResponse(auth.getPrincipal());
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


    @PostMapping(path = "/registration/register")
    public ResponseEntity<ResponseDto> register(@RequestBody RegistrationRequestDto registrationRequestDto) {
        log.info("[UserController] ----> /registration/register");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();
        try {
            String token = registrationService.register(registrationRequestDto);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = getUserResponse(auth.getPrincipal());
            responseDtoBuilder
                .timeStamp(now())
                .message("User Registration was successful.")
                .status(OK)
                .statusCode(OK.value())
                .data(new HashMap<>(){{
                    put("user", userResponse);
                    put("token", token);
                }})
                .build();

        } catch(IllegalStateException ise){
            responseDtoBuilder
                .timeStamp(now())
                .message("Registration attempt failed.")
                .status(HttpStatus.CONFLICT)
                .statusCode(HttpStatus.CONFLICT.value())
                .reason(ise.getMessage());
        }

        return ResponseEntity.ok(
            responseDtoBuilder.build()
        );
    }

    @GetMapping(path = "/registration/confirm")
    public ResponseEntity<ResponseDto> confirm(@RequestParam("token") String token) {
        log.info("[UserController] ----> /registration/confirm");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();
        try {
            registrationService.confirmToken(token);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = getUserResponse(auth.getPrincipal());
            responseDtoBuilder
                .timeStamp(now())
                .message("User Confirmation was Successful.")
                .status(OK)
                .statusCode(OK.value())
                .data(new HashMap<>(){{
                    put("user", userResponse);
                    put("token", token);
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
    @GetMapping(path = "/user/data")
    public ResponseEntity<ResponseDto> userHome(){
        log.info("[UserController] ----> /user/data");
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object userResponse = getUserResponse(auth.getPrincipal());

        return ResponseEntity.ok(
                ResponseDto.builder()
                        .timeStamp(now())
                        .message("There you go!")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(new HashMap<>(){{
                            put("user", userResponse);

                        }})
                        .build()
        );
    }


    @GetMapping(path = "/admin/data")
    public ResponseEntity<ResponseDto> adminHome(){
        log.info("[UserController] ----> /admin/data");
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object userResponse = getUserResponse(auth.getPrincipal());

        return ResponseEntity.ok(

                ResponseDto.builder()
                        .timeStamp(now())
                        .message("There you go!")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(new HashMap<>(){{
                            put("user", userResponse);
                        }})
                        .build()
        );
    }

    private Object getUserResponse(Object principal){
        return (principal instanceof User)? UserDisplayDto.createFromPrincipal((User) principal) : principal.toString();
    }

}


