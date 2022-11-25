package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.service.RegistrationService;
import com.app.food.team.foodapp.service.UserService;
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
@RequestMapping("${app.request-mapping}registration/")
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;
    private final RegistrationService registrationService;


    @PostMapping(path = "register")
    public ResponseEntity<ResponseDto> register(@RequestBody @Valid RegistrationRequestDto registrationRequestDto, Errors errors) {
        log.info("[UserController] ----> /registration/register");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();

        try {
            registrationService.registrationRequestValidation(registrationRequestDto, errors);
            String token = registrationService.register(registrationRequestDto);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = userService.getUserResponse(auth.getName());
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
                .status(HttpStatus.NOT_ACCEPTABLE)
                .statusCode(HttpStatus.NOT_ACCEPTABLE.value())
                .reason(ise.getMessage())
                .data(new HashMap<>(){{
                    put("errors", errors.getAllErrors());
                }});
        }

        return ResponseEntity.ok(
            responseDtoBuilder.build()
        );
    }

    @GetMapping(path = "confirm")
    public ResponseEntity<ResponseDto> confirm(@RequestParam("confirmation-token") String token) {
        log.info("[UserController] ----> registration/confirm");
        ResponseDto.ResponseDtoBuilder<?, ?> responseDtoBuilder = ResponseDto.builder();

        try {
            registrationService.confirmToken(token);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object userResponse = userService.getUserResponse(auth.getName());
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
                .status(HttpStatus.NOT_ACCEPTABLE)
                .statusCode(HttpStatus.NOT_ACCEPTABLE.value())
                .reason(ise.getMessage());
        }

        return ResponseEntity.ok(
                responseDtoBuilder.build()
        );

    }

}


