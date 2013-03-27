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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "solution_keyword")
public class SolutionKeyword implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "sk_id", nullable = false, updatable = false, unique = true)
	private Long id;

	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name="solution_keyword_solution_keyword_code",
				joinColumns={@JoinColumn(name="sk_id")},
				inverseJoinColumns={@JoinColumn(name="skc_id")})
	private Set<SolutionKeywordCode> solutionKeywordCodes = new HashSet<SolutionKeywordCode>(0);

	public SolutionKeyword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolutionKeyword(Set<SolutionKeywordCode> solutionKeywordCodes) {
		super();
		this.solutionKeywordCodes = solutionKeywordCodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((solutionKeywordCodes == null) ? 0 : solutionKeywordCodes.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (solutionKeywordCodes == null) {
			if (other.solutionKeywordCodes != null)
				return false;
		} else if (!solutionKeywordCodes.equals(other.solutionKeywordCodes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolutionKeyword [id=" + id + ", solutionKeywordCodes=" + solutionKeywordCodes + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<SolutionKeywordCode> getSolutionKeywordCodes() {
		return solutionKeywordCodes;
	}

	public void setSolutionKeywordCodes(Set<SolutionKeywordCode> solutionKeywordCodes) {
		this.solutionKeywordCodes = solutionKeywordCodes;
	}

}
