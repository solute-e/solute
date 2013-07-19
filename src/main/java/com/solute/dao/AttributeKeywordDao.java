package com.solute.dao;

import com.solute.entity.AttributeKeyword;

public interface AttributeKeywordDao {
	void insert(AttributeKeyword keyword);
	AttributeKeyword select(Long id);
	void delete(AttributeKeyword keyword);
}
