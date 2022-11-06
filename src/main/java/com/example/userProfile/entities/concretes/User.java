package com.example.userProfile.entities.concretes;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	@JsonProperty("id")
	private UUID id;

	@NotBlank
	@JsonProperty("userName")
	private String userName;

	@JsonProperty("password")
	@NotBlank
	private String password;

	@JsonProperty("name")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;
}
