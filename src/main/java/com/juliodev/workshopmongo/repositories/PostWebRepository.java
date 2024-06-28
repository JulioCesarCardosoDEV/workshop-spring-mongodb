package com.juliodev.workshopmongo.repositories;

import java.util.Date;
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
	
	@Query("{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<PostWeb> fullSearch(String text, Date minDate, Date maxDate);
}
