package com.solute.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	private String id;
	
	@Column
	private String location;
	
	@OneToMany(targetEntity = AttributeKeyword.class)
	@MapKey(name = "id")
	private Map<AttributeKeyword, Double> rates = new HashMap<AttributeKeyword, Double>();
	
	public User() {
	}
	
	public User(User user) {
		this.id = user.id;
		this.rates.putAll(user.rates);
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Map<AttributeKeyword, Double> getRates() {
		return rates;
	}

	public void setRates(
			Map<AttributeKeyword, Double> rates) {
		this.rates = rates;
	}
	
}
