package com.app.food.team.foodapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginRequestDto {
    @NotNull(message = "Email must be present")
    @NotBlank(message = "Email can't be empty")
    @Email( message = "Email field must be an email")
    private String email;

    @NotNull(message = "Password must be present")
    @NotBlank(message = "Password can't be empty")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters long")
    private String password;
}
