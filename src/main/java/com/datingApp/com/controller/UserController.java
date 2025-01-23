package com.datingApp.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datingApp.com.Entities.Users;
import com.datingApp.com.services.UserServicesImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServicesImpl userServicesImpl;
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user ){
		Users users=userServicesImpl.createUsers(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(users);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUser(@PathVariable long id){
		Optional<Users> user=userServicesImpl.getUsers(id);
		return ResponseEntity.status(HttpStatus.FOUND).build().of(user);
	}
	@GetMapping
	public ResponseEntity<List<Users>> getAll(){
		List<Users> users=userServicesImpl.getAllusers();
		return ResponseEntity.status(HttpStatus.FOUND).body(users);
	}
	@GetMapping("/{id}/matches")
	public ResponseEntity<List<Users>> Matches(@PathVariable long id,@RequestParam("limit") int limit){
		List<Users> users=userServicesImpl.findBYMatches(id, limit);
		return ResponseEntity.status(HttpStatus.FOUND).body(users);
	}
}
