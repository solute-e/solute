package com.solute.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="test_echo")
public class TestEcho {
	
	
	@Column(name="id", nullable=false)
	private String id;

	public TestEcho(String echo) {
		super();
		this.id = echo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
