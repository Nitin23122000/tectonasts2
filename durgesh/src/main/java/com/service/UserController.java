package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping
	public ResponseEntity<User> insertUser( @RequestBody User u){
		User user = userservice.insertUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable String id){
		User u = userservice.getuserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> list = userservice.getAllUser();
		return ResponseEntity.ok(list);
	}
	
	
}
