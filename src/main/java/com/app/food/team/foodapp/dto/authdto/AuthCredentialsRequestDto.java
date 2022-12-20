package com.app.food.team.foodapp.dto.authdto;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthCredentialsRequestDto {
    @Email(message = "Username must be an email")
    private String username;

    private String password;
}
