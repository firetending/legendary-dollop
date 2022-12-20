package com.app.food.team.foodapp.dto.authdto;

import com.app.food.team.foodapp.model.authmodel.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@SuperBuilder
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Boolean locked;
    private Boolean enabled;
    private Boolean expired;
    Collection<? extends GrantedAuthority> authorities;

    public static UserViewDto createFromUser(User user){
        return UserViewDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .authorities(user.getAuthorities())
            .enabled(user.getEnabled())
            .build();
    }
}
