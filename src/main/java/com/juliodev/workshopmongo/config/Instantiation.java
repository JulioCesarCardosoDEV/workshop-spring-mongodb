package com.juliodev.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juliodev.workshopmongo.domain.User;
import com.juliodev.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User renato = new User(null, "Renato Augusto", "renato@gmail.com");
		User carlos = new User(null, "Carlos de Souza", "carlos@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, renato, carlos));
		
	}

}
