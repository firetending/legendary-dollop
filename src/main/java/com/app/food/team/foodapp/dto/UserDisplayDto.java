package com.app.food.team.foodapp.dto;

import com.app.food.team.foodapp.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@SuperBuilder
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserDisplayDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Boolean locked;
    private Boolean enabled;
    private Boolean expired;
    Collection<? extends GrantedAuthority> authorities;

    public static UserDisplayDto createFromPrincipal(User user){
        return UserDisplayDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .authorities(user.getAuthorities())
            .enabled(user.getEnabled())
            .build();
    }
}
