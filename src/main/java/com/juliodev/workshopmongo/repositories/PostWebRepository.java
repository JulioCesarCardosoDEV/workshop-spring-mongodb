package com.juliodev.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juliodev.workshopmongo.domain.PostWeb;

@Repository
public interface PostWebRepository extends MongoRepository<PostWeb, String>{
	
}
