package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.dto.UserDisplayDto;
import com.app.food.team.foodapp.model.User;
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
    private final RegistrationService registrationService;



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
    public ResponseEntity<ResponseDto> register(@RequestBody @Valid RegistrationRequestDto registrationRequestDto, Errors errors) {
        log.info("[UserController] ----> /registration/register");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();

        try {
            registrationService.registrationRequestVerification(registrationRequestDto, errors);
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
                .reason(ise.getMessage())
                .data(new HashMap<>(){{
                    put("errors", errors.getAllErrors());
                }});
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


