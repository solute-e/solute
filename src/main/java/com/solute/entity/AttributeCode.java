package com.solute.entity;


public enum AttributeCode {
	RECOGNITION("Recognition"),
	KNOWLEDGE("Knowledge");
	
	private String description;
	
	private AttributeCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
