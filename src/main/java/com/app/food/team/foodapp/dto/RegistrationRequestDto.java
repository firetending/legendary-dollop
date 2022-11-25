package com.app.food.team.foodapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class RegistrationRequestDto extends LoginRequestDto{
    @NotNull(message = "Firstname must be present.")
    @Size(min = 3, max = 128, message = "First name must be between 3 and 128 characters long.")
    private String firstName;

    @NotNull(message = "Lastname must be present.")
    @Size(min = 3, max = 128, message = "Lastname must be between 3 and 128 characters long.")
    private String lastName;

    @NotNull(message = "Password verification must be present")
    private String verifyPassword;
}