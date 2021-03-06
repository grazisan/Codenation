package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

	@EmbeddedId
	private CandidateIdentity candidateIdentity;

	@NotNull
	private int status;

	@CreatedDate
	@NotNull
	private LocalDateTime createdAt;

	public CandidateIdentity getCandidateIdentity() {
		return candidateIdentity;
	}

	public void setCandidateIdentity(CandidateIdentity candidateIdentity) {
		this.candidateIdentity = candidateIdentity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
