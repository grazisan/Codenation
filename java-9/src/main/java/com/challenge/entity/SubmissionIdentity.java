package com.challenge.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class SubmissionIdentity implements Serializable{

	@ManyToOne
	private User user;

	@ManyToOne
	private Challenge challenge;
	
	
	
	

}
