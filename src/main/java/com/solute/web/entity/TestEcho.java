package com.solute.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_echo")
public class TestEcho {
	
	@Id
	@Column(name="id", nullable=false)
	private String id;
	
	@Column(name="echo", nullable=false)
	private String echo;

	public TestEcho(String id, String echo) {
		super();
		this.id = id;
		this.echo = echo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}
	
	
}
