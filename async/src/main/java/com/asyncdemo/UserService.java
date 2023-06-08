package com.asyncdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;
	
	Object target;
	Logger log = LoggerFactory.getLogger(UserService.class);

	public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception{
		long start=System.currentTimeMillis();
			
		List<User> users=parseCSV(file);
		log.info("saving list of user of size"+users.size()+""+Thread.currentThread().getName());
		users=UserRepository.saveAll(users);
				
		long end=System.currentTimeMillis();
		log.info("task completion time : "+(end-start));
		return CompletableFuture.completedFuture(users);
	}
	
	public CompletableFuture<List<User>> findAllUsers(){
		log.info("get list of user by"+Thread.currentThread().getName());
			List<User> users=UserRepository.findAll();
			return CompletableFuture.completedFuture(users);
			
	}
	
	private List<User> parseCSV(final MultipartFile file) throws Exception {
		  final List<User> users = new ArrayList<>();
	        try {
	            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	                String line;
	                while ((line = br.readLine()) != null) {
	                    final String[] data = line.split(",");
	                    final User user = new User();
	                    user.setName(data[0]);
	                    user.setEmail(data[1]);
	                    user.setGender(data[2]);
	                    users.add(user);
	                }
	                return users;
	            }
	        } catch (final IOException e) {
	            log.error("Failed to parse CSV file {}"+ e);
	            throw new Exception("Failed to parse CSV file {}"+ e);
	        }
	    }
		
	}

