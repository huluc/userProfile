package com.example.userProfile.webApi.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userProfile.business.abstracts.UserService;
import com.example.userProfile.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping(path = "{id}")
	public User getPersonById(@PathVariable("id") UUID id) {
		return userService.getUserById(id).orElse(null);
	}

	@PostMapping
	public void addUser(@Valid @NonNull @RequestBody User user) {
		userService.addUser(user);
	}

	@DeleteMapping(path = "{id}")
	public void deleteUserById(@PathVariable("id") UUID id) {
		userService.deleteUserById(id);
	}

	@PutMapping(path = "{id}")
	public void updateUserById(@PathVariable("id") UUID id, @RequestBody User personToUpdate) {
		userService.updateUserById(id, personToUpdate);
	}

}
