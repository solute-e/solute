package com.solute.entity;

import java.io.Serializable;
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
	
	@Column
	@Index(name = "code_idx")
	@Enumerated(EnumType.STRING)
	private AttributeCode code;
	
	@Column(nullable = false)
	@OneToMany(targetEntity = Keyword.class)	
	private Set<Keyword> keywords;
	
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
