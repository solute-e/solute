package com.solute.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="solution_keyword_code")
public class SolutionKeywordCode implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="skc_id", nullable=false, updatable=false, unique=true)
	private Long id;
	
	@NotEmpty
	@NotNull
	@Column(name="skc_name", nullable=false, unique=false)
	private String name;
	
	@ManyToMany(mappedBy="solutionKeywordCodes")
	private Set<SolutionKeyword> solutionKeywords = new HashSet<SolutionKeyword>(0);
	
	public SolutionKeywordCode() {
		super();
	}

	public SolutionKeywordCode(String name) {
		super();
		this.name = name;
	}
	
	public SolutionKeywordCode(String name, Set<SolutionKeyword> solutionKeywords) {
		super();
		this.name = name;
		this.solutionKeywords = solutionKeywords;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolutionKeywordCode other = (SolutionKeywordCode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "SolutionKeywordCode [id=" + id + ", name=" + name + "]";
	}
	
	
}
