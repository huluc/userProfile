package com.example.userProfile.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.userProfile.entities.concretes.User;

public interface UserRepository {
	List<User> getAll();

	Optional<User> getUserById(UUID id);

	int addUser(UUID id, User user);

	default int addUser(User user) {
		UUID id = UUID.randomUUID();
		return addUser(id, user);

	}

	int deleteUserById(UUID id);

	int updateUserById(UUID id, User user);

}
