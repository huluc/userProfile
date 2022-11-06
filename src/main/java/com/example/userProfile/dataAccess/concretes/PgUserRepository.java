package com.example.userProfile.dataAccess.concretes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.userProfile.dataAccess.abstracts.UserRepository;
import com.example.userProfile.entities.concretes.User;

@Repository("postgres")
public class PgUserRepository implements UserRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PgUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getAll() {
		final String sql = "SELECT id, userName, password, firstName, lastName FROM users";

		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String userName = resultSet.getString("userName");
			String password = resultSet.getString("password");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			return new User(id, userName, password, firstName, lastName);
		});
	}

	@Override
	public Optional<User> getUserById(UUID id) {
		final String sql = "SELECT id, userName, password, firstName, lastName FROM users WHERE id = ?";

		User user = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
			UUID userId = UUID.fromString(resultSet.getString("id"));
			String userName = resultSet.getString("userName");
			String password = resultSet.getString("password");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			return new User(userId, userName, password, firstName, lastName);
		}, new Object[] { id });

		return Optional.ofNullable(user);
	}

	@Override
	public int addUser(UUID id, User user) {
		final String sql = "INSERT INTO users(id, userName, password, firstName, lastName) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql,
				new Object[] { id, user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName() });
	}

	@Override
	public int deleteUserById(UUID id) {
		final String sql = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public int updateUserById(UUID id, User user) {
		final String sql = "UPDATE users SET userName = ?, password = ?, firstName = ?, lastName = ? WHERE id = ?";
		return jdbcTemplate.update(sql,
				new Object[] { user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(), id });
	}

}
