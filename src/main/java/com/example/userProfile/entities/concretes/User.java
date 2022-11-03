package com.example.userProfile.entities.concretes;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private UUID id;
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	private String firstName;
	private String lastName;

	public User() {
	}

	public User(@JsonProperty("id") UUID id, @JsonProperty("userName") String userName,
			@JsonProperty("password") String password, @JsonProperty("name") String firstName,
			@JsonProperty("lastName") String lastName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
