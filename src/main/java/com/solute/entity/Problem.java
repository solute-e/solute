package com.solute.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Problem {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(targetEntity = AttributeKeyword.class)
	@MapKey(name = "id")
	private Map<AttributeKeyword, Integer> rate = new HashMap<AttributeKeyword, Integer>();
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = RealProblem.class)
	private RealProblem realProblem;

	public Long getId() {
		return id;
	}

	public Map<AttributeKeyword, Integer> getRate() {
		return rate;
	}

	public RealProblem getRealProblem() {
		return realProblem;
	}
	
	public Problem setName(Map<AttributeKeyword, Integer> rate) {
		this.rate = rate;
		return this;
	}
	
	public Problem setName(RealProblem realProblem) {
		this.realProblem = realProblem;
		return this;
	}
}
