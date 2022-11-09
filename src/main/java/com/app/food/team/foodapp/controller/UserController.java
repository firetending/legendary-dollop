package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @GetMapping("/ping")
    public ResponseEntity<Response> ping(){
        log.info("Processing ping request");
        return ResponseEntity.ok( // we can use .created here
                Response.builder()
                        .timeStamp(now())
                        .message("Service is up")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
