package com.solute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

@Entity
public class User {
	@Id
	@GeneratedValue
	private String id;
	
	@Column(nullable = false)
	@Index()
	private String userId;
}
