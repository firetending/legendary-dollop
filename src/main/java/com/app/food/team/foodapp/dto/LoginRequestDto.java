package com.app.food.team.foodapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginRequestDto {
    @NotNull(message = "Email must be present.")
    @Email( message = "Email field must be an email")
    private String email;

    @NotNull(message = "Password must be present.")
    @Length(min = 8, max = 128, message = "Password must be between 8 and 128 characters long")
    private String password;
}
