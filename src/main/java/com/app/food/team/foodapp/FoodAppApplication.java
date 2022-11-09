package com.app.food.team.foodapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

	@Bean
	CommandLineRunner run(){ // Inject stuff here. Repositories for instance.
		return args -> {
			log.info("Run initialization here... ");
		};
	}

}
