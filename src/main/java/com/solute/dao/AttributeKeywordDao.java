package com.solute.dao;

import org.springframework.stereotype.Repository;

import com.solute.entity.AttributeKeyword;
import com.solute.utils.HibernateSupportDao;

@Repository
public class AttributeKeywordDao extends HibernateSupportDao {

	public void update(AttributeKeyword keyword) {
		session().saveOrUpdate(keyword);
	}

	public AttributeKeyword select(Long id) {
		return (AttributeKeyword)session().get(AttributeKeyword.class, id);
	}

	public void delete(AttributeKeyword keyword) {
		session().delete(keyword);
	}
}
