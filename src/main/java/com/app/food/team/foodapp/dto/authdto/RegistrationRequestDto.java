package com.app.food.team.foodapp.dto.authdto;

import com.app.food.team.foodapp.dto.authdto.LoginRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class RegistrationRequestDto extends LoginRequestDto {
    @NotNull(message = "First name must be present.")
    @Size(min = 3, max = 128, message = "First name must be between 3 and 128 characters long.")
    private String firstName;

    @NotNull(message = "Last name must be present.")
    @Size(min = 3, max = 128, message = "Last name must be between 3 and 128 characters long.")
    private String lastName;

    @NotNull(message = "Password verification must be present")
    private String verifyPassword;
}