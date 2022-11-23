package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("${app.request-mapping}data/")
@AllArgsConstructor
public class DataController {

    private UserService userService;

    @GetMapping(path = "user")
    public ResponseEntity<ResponseDto> userData(Authentication authentication){
        log.info("[UserController] ----> user/data");

        Object userResponse = userService.getUserResponse(authentication.getName());
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


    @GetMapping(path = "admin")
    public ResponseEntity<ResponseDto> adminData(Authentication authentication){
        log.info("[UserController] ----> admin/data");

        Object userResponse = userService.getUserResponse(authentication.getName());
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

    // Endpoints can be secured like this:
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("example")
    public String someAdminEndpoint(){
        return "Hello Admin!";
    }
}
