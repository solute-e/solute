package com.solute.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SolutionKeyword {
	@Id
	@GeneratedValue
	@Column(name="sk_id", nullable=false, updatable=false, unique=true)
	private Long id;
	
	@Column(name="skc_id", nullable=false, updatable=false, unique=true)
	private Long skcId;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="skc_id")
	private List<SolutionKeywordCode> codes;

	public SolutionKeyword() {
		super();
	}

	public SolutionKeyword(Long skc_id) {
		super();
	}

	public Long getId() {
		return id;
	}

	public Long getSkcId() {
		return skcId;
	}

	public void setSkcId(Long skcId) {
		this.skcId = skcId;
	}

	public List<SolutionKeywordCode> getCodes() {
		return codes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codes == null) ? 0 : codes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((skcId == null) ? 0 : skcId.hashCode());
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
		if (skcId == null) {
			if (other.skcId != null)
				return false;
		} else if (!skcId.equals(other.skcId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolutionKeyword [id=" + id + ", skcId=" + skcId + ", codes=" + codes + "]";
	}

}
