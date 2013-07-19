package com.solute.dao.impl;

import org.springframework.stereotype.Repository;

import com.solute.dao.AttributeKeywordDao;
import com.solute.entity.AttributeKeyword;
import com.solute.utils.HibernateSupportDao;

@Repository
public class HAttributeKeywordDao extends HibernateSupportDao implements AttributeKeywordDao {

	@Override
	public void insert(AttributeKeyword keyword) {
		session().save(keyword);
	}

	@Override
	public AttributeKeyword select(Long id) {
		return (AttributeKeyword)session().get(AttributeKeyword.class, id);
	}

	@Override
	public void delete(AttributeKeyword keyword) {
		session().delete(keyword);
	}
	
}
