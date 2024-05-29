package com.juliodev.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.juliodev.workshopmongo.domain.PostWeb;

@Repository
public interface PostWebRepository extends MongoRepository<PostWeb, String>{
	
	@Query("{'title':{ $regex: ?0, $options: 'i'}}")
	List<PostWeb> searchTitle(String text);
	
	List<PostWeb> findByTitleContainingIgnoreCase(String text);
}
