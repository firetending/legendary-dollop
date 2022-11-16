package com.app.food.team.foodapp;


import com.app.food.team.foodapp.enums.Role;
import com.app.food.team.foodapp.model.User;
import com.app.food.team.foodapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootApplication
public class FoodAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

	@Bean
	CommandLineRunner run(final UserRepository userRepository, final BCryptPasswordEncoder bCryptPasswordEncoder){ // Inject stuff here. Repositories for instance.
		return args -> {
			log.info("Run initialization here... ");
			User user = User.builder()
					.firstName("John")
					.lastName("Smith")
					.email("user@hello.com")
					.password(bCryptPasswordEncoder.encode("password"))
					.role(Role.USER)
					.enabled(true)
					.build();
			userRepository.save(user);

			user = User.builder()
					.firstName("Anna")
					.lastName("Williams")
					.email("admin@hello.com")
					.password(bCryptPasswordEncoder.encode("password"))
					.role(Role.ADMIN)
					.enabled(true)
					.build();
			userRepository.save(user);
		};
	}

}
