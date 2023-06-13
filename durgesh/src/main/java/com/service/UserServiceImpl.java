package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User insertUser(User u) {
		
		String uid = UUID.randomUUID().toString();
		u.setUid(uid);
		return userrepository.save(u);
	}

	@Override
	public List<User> getAllUser() {
		return userrepository.findAll();
	}

	@Override
	public User getuserById(String id) {
		User user = userrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found with this id : "+id));
		
		//fetching rating of the user
		ArrayList ratingsofuser = restTemplate.getForObject("http://localhost:8686/ratings/users/"+user.getUid(), ArrayList.class);
		logger.info("{}",ratingsofuser);
		/*
		 * List<Rating> ratingList=ratingsofuser.stream().map(rating->{
		 * 
		 * ResponseEntity<Hotel> ratingg=
		 * restTemplate.getForEntity("http://localhost:8686/ratings/users/",
		 * Hotel.class); return rating; }).collect(Collectors.toList());
		 */
		
		user.setRatings(ratingsofuser);
		return user;
	}

}
