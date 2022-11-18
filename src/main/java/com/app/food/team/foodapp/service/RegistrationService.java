package com.app.food.team.foodapp.service;


import com.app.food.team.foodapp.dto.RegistrationRequestDto;
import com.app.food.team.foodapp.enums.Role;
import com.app.food.team.foodapp.model.ConfirmationToken;
import com.app.food.team.foodapp.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailServiceInterface emailService;

    public String register(RegistrationRequestDto request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String token = userService.signUpUser(
            User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.USER)
                .build()
        );

        final String BASE_URL = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String link = BASE_URL + "/api/v1/registration/confirm?token=" + token;
        log.info("Confirm user with email:" +
                 request.getEmail() +
                 " using this URL: " +
                link
        );

        // emailService.send(request.getEmail(), emailService.buildEmail(request.getFirstName(), link));
        return token;
    }

    @Transactional
    public void confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableAppUser(confirmationToken.getUser().getEmail());
    }



}