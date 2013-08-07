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
	private Map<AttributeKeyword, Double> rates = new HashMap<AttributeKeyword, Double>();
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = RealProblem.class)
	private RealProblem realProblem;

	public Map<AttributeKeyword, Double> getRates() {
		return rates;
	}

	public void setRates(Map<AttributeKeyword, Double> rates) {
		this.rates = rates;
	}

	public RealProblem getRealProblem() {
		return realProblem;
	}

	public void setRealProblem(RealProblem realProblem) {
		this.realProblem = realProblem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
