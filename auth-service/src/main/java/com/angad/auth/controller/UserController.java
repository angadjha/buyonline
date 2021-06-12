package com.angad.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angad.auth.model.User;
import com.angad.auth.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User userRequest){
		    User user = userService.createUser(userRequest);
		    return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) throws NotFoundException{
		    Optional<User> user = userService.getUser(id);
		    return new ResponseEntity<User>(user.orElseThrow(() -> new NotFoundException("This user does not exist")), HttpStatus.FOUND);
	}
}
