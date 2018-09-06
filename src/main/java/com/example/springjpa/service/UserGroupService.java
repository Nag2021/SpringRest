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

import com.example.springjpa.dao.UserGroupRepository;
import com.example.springjpa.exception.UserGroupNotFoundException;
import com.example.springjpa.model.User;
import com.example.springjpa.model.UserGroup;

/**
 * @author nageswara.eluri
 *
 */
@RequestMapping("/usergroupdetails")
@RestController
public class UserGroupService {
	
	@Autowired
	UserGroupRepository userGroupRepository;
	// To fetch all the user groups
	@GetMapping("/usersgroup")
	public List<UserGroup> getAllUsersGroups() {
		return userGroupRepository.findAll();
	}
	// To fetch a user group by group id
	@GetMapping("/usersgroup/{id}")
	public UserGroup getUserGroupById(@PathVariable(value = "id") Long id) {
		return userGroupRepository.findById(id)
				.orElseThrow(() -> new UserGroupNotFoundException("UserGroup", "id", id));
	}
    // To post a user group 
	@PostMapping("/usersgroup")
	public UserGroup createUserGroup( @RequestBody UserGroup userGroup) {
		return userGroupRepository.save(userGroup);
	}
    // To edit an existing user group by passing a id
	@PutMapping("/usersgroup/{id}")
	public UserGroup updateUserGroup(@PathVariable(value = "id") Long id, @Valid @RequestBody UserGroup userGroupDetails) {

		UserGroup userGroup = userGroupRepository.findById(id)
				.orElseThrow(() -> new UserGroupNotFoundException("UserGroup", "id", id));

		userGroup.setGroupName(userGroupDetails.getGroupName());

		UserGroup updatedUserGroup = userGroupRepository.save(userGroup);
		return updatedUserGroup;
	}
	// To delete an existing user group by passing a id
	@DeleteMapping("/usersgroup/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {

		UserGroup userGroup = userGroupRepository.findById(id)
				.orElseThrow(() -> new UserGroupNotFoundException("UserGroup", "id", id));

		userGroupRepository.delete(userGroup);
		return ResponseEntity.ok().build();
	}
}
