package com.solute.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Problem {
	@Id
	@GeneratedValue
	private Long id;
	
	
}
