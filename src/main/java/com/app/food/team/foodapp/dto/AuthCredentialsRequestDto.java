package com.app.food.team.foodapp.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthCredentialsRequestDto {
    @Email(message = "User name must be your email")
    private String username;

    private String password;
}
