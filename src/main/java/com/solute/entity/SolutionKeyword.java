package com.solute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SolutionKeyword {
	@Id
	@GeneratedValue
	@Column(name="sk_id", nullable=false, updatable=false, unique=true)
	private Integer id;
	
	@OneToOne
	private SolutionKeywordCode code;
}
