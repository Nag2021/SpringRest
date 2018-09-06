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

import com.example.springjpa.dao.UserRightsRepository;
import com.example.springjpa.exception.UserNotFoundException;
import com.example.springjpa.exception.UserRightsNotFoundException;
import com.example.springjpa.model.UserRights;

/**
 * @author nageswara.eluri
 *
 */
@RequestMapping("/userrightsdetails")
@RestController
public class UserRightsService {
	
	@Autowired
	UserRightsRepository userRightsRepository;
	// To get all the user rights
	@GetMapping("/usersrights")
	public List<UserRights> getAllUsersRights() {
		return userRightsRepository.findAll();
	}
	// To get an user right by passing a id
	@GetMapping("/usersrights/{id}")
	public UserRights getUserRightsById(@PathVariable(value = "id") Long id) {
		return userRightsRepository.findById(id)
				.orElseThrow(() -> new UserRightsNotFoundException("UserRights", "id", id));
	}
	// To create an user right
	@PostMapping("/usersrights")
	public UserRights createUserRight( @RequestBody UserRights userRights) {
		return userRightsRepository.save(userRights);
	}
	// To edit an existing user right by passing a id
	@PutMapping("/usersrights/{id}")
	public UserRights updateUserRights(@PathVariable(value = "id") Long id, @Valid @RequestBody UserRights userRightsDetails) {

		UserRights userRights = userRightsRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User", "id", id));

		userRightsDetails.setRightName(userRightsDetails.getRightName());

		UserRights updatedUserRights = userRightsRepository.save(userRights);
		return updatedUserRights;
	}
	// To delete an existing user right by passing a id
	@DeleteMapping("/usersrights/{id}")
	public ResponseEntity<UserRights> deleteUser(@PathVariable(value = "id") Long id) {

		UserRights userRights = userRightsRepository.findById(id)
				.orElseThrow(() -> new UserRightsNotFoundException("UserRight", "id", id));

		userRightsRepository.delete(userRights);
		return ResponseEntity.ok().build();
	}
}
