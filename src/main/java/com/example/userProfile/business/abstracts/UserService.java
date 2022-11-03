package com.example.userProfile.business.abstracts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.userProfile.entities.concretes.User;

public interface UserService {

	List<User> getAll();

	Optional<User> getUserById(UUID id);

	int addUser(User user);

	int deleteUserById(UUID id);

	int updateUserById(UUID id, User user);

}
