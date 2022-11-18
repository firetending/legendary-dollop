package com.app.food.team.foodapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder // https://en.wikipedia.org/wiki/Builder_pattern#Java
@JsonInclude(NON_NULL)  // https://www.javaguides.net/2019/04/jackson-jsoninclude-example.html
public class ResponseDto {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data; // ? means anything
}