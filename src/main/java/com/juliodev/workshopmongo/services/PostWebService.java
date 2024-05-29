package com.juliodev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliodev.workshopmongo.domain.PostWeb;
import com.juliodev.workshopmongo.repositories.PostWebRepository;
import com.juliodev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostWebService {
	
	@Autowired
	private PostWebRepository postWebRepository;

	public PostWeb findbyID(String id){
		Optional<PostWeb> post = postWebRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<PostWeb> findByTitle(String text){
		return postWebRepository.findByTitleContainingIgnoreCase(text);
	}
}
