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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "solution_keyword", 
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = "sk_id"), 
	})
public class SolutionKeyword implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "sk_id", nullable = false, updatable = false, unique = true)
	private Long id;

	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "skc_id", nullable=false)
	private Set<SolutionKeywordCode> codes = new HashSet<SolutionKeywordCode>(0);

	public SolutionKeyword() {
		super();
	}

	public SolutionKeyword(Set<SolutionKeywordCode> codes) {
		super();
		this.codes = codes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codes == null) ? 0 : codes.hashCode());
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
		SolutionKeyword other = (SolutionKeyword) obj;
		if (codes == null) {
			if (other.codes != null)
				return false;
		} else if (!codes.equals(other.codes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolutionKeyword [id=" + id + ", codes=" + codes + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<SolutionKeywordCode> getCodes() {
		return codes;
	}

	public void setCodes(Set<SolutionKeywordCode> codes) {
		this.codes = codes;
	}

}
