package com.jahia.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jahia.demo.entities.User;
import com.jahia.demo.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/users")
	void addUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@PostMapping("/users/delete")
	List<User> deleteUser(@RequestBody User user) {
		userRepository.delete(user);
		return (List<User>) userRepository.findAll();
	}
	
	@PostMapping("/users/update")
	List<User> updateUser(@RequestBody User user) {
		userRepository.save(user);
		return (List<User>) userRepository.findAll();
	}
}
