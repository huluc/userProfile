package com.example.userProfile.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.userProfile.dataAccess.abstracts.UserRepository;
import com.example.userProfile.entities.concretes.User;

@Repository("inMemoryRepository")
public class InMemoryUserRepository implements UserRepository {

	private static List<User> DB = new ArrayList<>();

	@Override
	public List<User> getAll() {

		return DB;
	}

	@Override
	public Optional<User> getUserById(UUID id) {

		return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	@Override
	public int addUser(UUID id, User user) {
		DB.add(new User(id, user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName()));

		return 1;
	}

	@Override
	public int deleteUserById(UUID id) {
		Optional<User> userMaybe = getUserById(id);
		if (userMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(userMaybe.get());
		return 1;

	}

	@Override
	public int updateUserById(UUID id, User update) {
		return getUserById(id).map(user -> {
			int indexOfUserToUpdate = DB.indexOf(user);
			System.out.println("Ok"+ indexOfUserToUpdate);

			if (indexOfUserToUpdate >= 0) {
				DB.set(indexOfUserToUpdate, new User(id, update.getUserName(), update.getPassword(),
						update.getFirstName(), update.getLastName()));
				return 1;

			}
			System.out.println("Ok degil");
			return 0;
		}).orElse(0);
	}

}
