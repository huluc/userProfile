package com.example.userProfile.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.userProfile.business.abstracts.UserService;
import com.example.userProfile.dataAccess.abstracts.UserRepository;
import com.example.userProfile.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserManager(@Qualifier("postgres") UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public Optional<User> getUserById(UUID id) {
		return userRepository.getUserById(id);
	}

	@Override
	public int addUser(User user) {
		return userRepository.addUser(user);
	}

	@Override
	public int deleteUserById(UUID id) {
		return userRepository.deleteUserById(id);
	}

	@Override
	public int updateUserById(UUID id, User user) {
		return userRepository.updateUserById(id, user);
	}

}
