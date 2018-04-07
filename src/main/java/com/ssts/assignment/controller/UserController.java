package com.ssts.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssts.assignment.model.User;
import com.ssts.assignment.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/kyyba")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// Create a new User
	@PostMapping("/createusers")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	// Get All Users
	@GetMapping(value = "/getusers")
	public List<User> getAllNotes() {
		return userRepository.findAll();
	}

	// Get a Single User
	@GetMapping("/getusers/")
	public ResponseEntity<User> getUserById(@RequestParam(value = "empId") Long empId) {
		User user = userRepository.getOne(empId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	// Update a User
	@PostMapping("/updateusers/")
	public ResponseEntity<User> updateUser(@RequestParam(value = "empId") Long empId,
			@Valid @RequestBody User userDetails) {
		User user = userRepository.findOne(empId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		user.setEmailId(userDetails.getEmailId());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		;

		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	// Delete a Note
	@GetMapping("/deleteusers/")
	public ResponseEntity<User> deleteNote(@RequestParam(value = "empId") Long empId) {
		User user = userRepository.findOne(empId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}

}
