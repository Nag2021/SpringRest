package com.example.springjpa.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.dao.UserRepository;
import com.example.springjpa.exception.UserNotFoundException;
import com.example.springjpa.model.User;

/**
 * @author nageswara.eluri
 *
 */
@RequestMapping("/userdetails")
@RestController
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	// To get all the users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	// To get an user by passing a id
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User", "id", id));
	}
	// To create a new user 
	@PostMapping("/users")
	public User createUser( @RequestBody User user) {
		return userRepository.save(user);
	}
	// To edit an existing user by passing a id
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User", "id", id));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());

		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	// To delete an existing user by passing a id
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User", "id", id));

		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}
}
