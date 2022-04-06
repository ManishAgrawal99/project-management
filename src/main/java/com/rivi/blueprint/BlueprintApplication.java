package com.rivi.blueprint;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rivi.blueprint.model.User;
import com.rivi.blueprint.repository.UserRepository;

@SpringBootApplication
public class BlueprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueprintApplication.class, args);
	}

	//Temporary Runner code to create users
	
//	@Bean
//	CommandLineRunner runner(UserRepository repository) {
//		return args -> {
//			User user = new User("Manish3", "manish3@gmail.com", true);
//			repository.save(user);
//		};
//	}
	
}
