package com.jdbc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao userdao;
	
	@PostMapping("/insert")
	public ResponseEntity<User> insertUser( @RequestBody User u) {
		try { 
		int insert = this.userdao.insertUser(u);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/showall")
	public ResponseEntity< List<User>> getAllUser(){
		List<User> list = this.userdao.getAllUser();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") int id) {
		User byId = this.userdao.getById(id);
		if(byId==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(byId));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User u) {
		   try {
			   this.userdao.updateUser(u);
			   return ResponseEntity.status(HttpStatus.OK).body(u);
			   
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		
		try {
			this.userdao.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
