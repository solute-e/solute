package com.solute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="solution_keyword_code")
public class SolutionKeywordCode {
	@Id
	@GeneratedValue
	@Column(name="skc_id", nullable=false, updatable=false, unique=true)
	private Integer id;
	
	@Column(name="skc_name", nullable=false, unique=false)
	private String name;
}
