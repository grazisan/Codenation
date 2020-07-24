package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

	@EmbeddedId
	private SubmissionIdentity submissionIdentity;

	@NotNull
	private float score;

	@CreatedDate
	@NotNull
	private LocalDateTime createdAt;

	public SubmissionIdentity getSubmissionIdentity() {
		return submissionIdentity;
	}

	public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
		this.submissionIdentity = submissionIdentity;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
