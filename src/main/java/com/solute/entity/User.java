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
	private Map<AttributeKeyword, Integer> majorKeywordRates = new HashMap<AttributeKeyword, Integer>();
	
	@OneToMany(targetEntity = AttributeKeyword.class)
	@MapKey(name = "id")
	private Map<AttributeKeyword, Integer> minorKeywordRates = new HashMap<AttributeKeyword, Integer>();
	
	public User() {
	}
	
	public User(User user) {
		this.id = user.id;
		this.majorKeywordRates.putAll(user.majorKeywordRates);
		this.minorKeywordRates.putAll(user.minorKeywordRates);
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Map<AttributeKeyword, Integer> getMajorKeywordRates() {
		return majorKeywordRates;
	}

	public void setMajorKeywordRates(
			Map<AttributeKeyword, Integer> majorKeywordRates) {
		this.majorKeywordRates = majorKeywordRates;
	}

	public Map<AttributeKeyword, Integer> getMinorKeywordRates() {
		return minorKeywordRates;
	}

	public void setMinorKeywordRates(
			Map<AttributeKeyword, Integer> minorKeywordRates) {
		this.minorKeywordRates = minorKeywordRates;
	}
	
}
