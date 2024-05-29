package com.juliodev.workshopmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juliodev.workshopmongo.domain.PostWeb;
import com.juliodev.workshopmongo.services.PostWebService;
@RestController
@RequestMapping(value="/posts")
public class PostWebController {
	
	@Autowired
	private PostWebService postWebService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PostWeb> findByID(@PathVariable String id){
		PostWeb obj = postWebService.findbyID(id);
		return ResponseEntity.ok().body(obj);
	}

}
