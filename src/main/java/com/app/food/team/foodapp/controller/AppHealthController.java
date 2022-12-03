package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // replace this with cors config in SecurityConfiguration
@RequestMapping("${app.request-mapping}")
@AllArgsConstructor
public class AppHealthController {
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
}
