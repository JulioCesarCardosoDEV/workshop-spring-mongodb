package com.juliodev.workshopmongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juliodev.workshopmongo.domain.User;
import com.juliodev.workshopmongo.dto.UserDTO;
import com.juliodev.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findByID(@PathVariable String id){
		User obj = userService.findbyID(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

}
