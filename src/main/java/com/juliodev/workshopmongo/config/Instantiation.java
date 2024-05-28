package com.juliodev.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juliodev.workshopmongo.domain.PostWeb;
import com.juliodev.workshopmongo.domain.User;
import com.juliodev.workshopmongo.dto.AuthorDTO;
import com.juliodev.workshopmongo.repositories.PostWebRepository;
import com.juliodev.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostWebRepository postWebRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postWebRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User renato = new User(null, "Renato Augusto", "renato@gmail.com");
		User carlos = new User(null, "Carlos de Souza", "carlos@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, renato, carlos));
		
		PostWeb post1 = new PostWeb(null, sdf.parse("21/03/2018"), "Partiu Caldas Novas", "Vou viajar com minha família", new AuthorDTO(maria));
		PostWeb post2 = new PostWeb(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postWebRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
