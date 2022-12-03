package com.app.food.team.foodapp.service;

import com.app.food.team.foodapp.dto.LoginRequestDto;
import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Slf4j
@Service
@AllArgsConstructor
public class ValidationService {
    private final UserService userService;

    public void loginRequestValidation(LoginRequestDto request, Errors errors){
        if (errors.hasErrors()) {
            throw new IllegalStateException("Login request has errors");
        }
    }
    public void registrationRequestValidation(RegistrationRequestDto request, Errors errors){
        if (userService.userExists(request.getEmail())) {
            errors.rejectValue("email", "email.already.exists", "Email already Exist");
        }
        if (!request.getPassword().equals(request.getVerifyPassword())) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords don't match");
        }
        if (errors.hasErrors()){ throw new IllegalStateException("Registration request has errors"); }
    }
}
