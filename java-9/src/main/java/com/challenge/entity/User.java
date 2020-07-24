package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String fullName;

	@NotNull
	@NotBlank
	@Email
	@Size(max = 100)
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nickname;

	@NotNull
	@NotBlank
	@Size(max = 255)
	private String password;

	@CreatedDate
	@NotNull
	private LocalDateTime createdAt;

	@OneToMany
	private List<Submission> submissions;

	@OneToMany
	private List<Candidate> candidates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
