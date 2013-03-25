package com.solute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="solution_keyword")
public class SolutionKeyword {
	@Id
	@GeneratedValue
	@Column(name="sk_id", nullable=false, updatable=false, unique=true)
	private Integer id;
	
	@Column(name="skc_id", nullable=false, updatable=false, unique=true)
	private Integer skcId;
	
	@OneToOne(mappedBy="skc_id")
	private SolutionKeywordCode code;
}
