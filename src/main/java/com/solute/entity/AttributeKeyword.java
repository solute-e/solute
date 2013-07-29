package com.solute.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Index;


@Entity
public class AttributeKeyword implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@Index(name = "code_idx")
	@Enumerated(EnumType.STRING)
	private AttributeCode code;
	
	@Column(nullable = false)
	private Integer defaultRate;
	
	@Column(nullable = false)
	@OneToMany(targetEntity = Keyword.class)	
	private Set<Keyword> keywords = new HashSet<Keyword>();
	
	
	public AttributeKeyword() {
		super();
	}
	
	public AttributeKeyword(Long id, AttributeCode code) {
		super();
		this.id = id;
		this.code = code;
	}
	
	public AttributeKeyword(AttributeCode code) {
		super();
		this.code = code;
	}
	
	public AttributeKeyword(Long id, AttributeCode code, Integer defaultRate) {
		super();
		this.id = id;
		this.code = code;
		this.defaultRate = defaultRate;
	}

	public Integer getDefaultRate() {
		return defaultRate;
	}

	public void setDefaultRate(Integer defaultRate) {
		this.defaultRate = defaultRate;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((defaultRate == null) ? 0 : defaultRate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeKeyword other = (AttributeKeyword) obj;
		if (code != other.code)
			return false;
		if (defaultRate == null) {
			if (other.defaultRate != null)
				return false;
		} else if (!defaultRate.equals(other.defaultRate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		return true;
	}
	
}
