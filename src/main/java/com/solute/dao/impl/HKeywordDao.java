package com.solute.dao.impl;

import org.springframework.stereotype.Repository;

import com.solute.dao.KeywordDao;
import com.solute.entity.Keyword;
import com.solute.utils.HibernateSupportDao;

@Repository
public class HKeywordDao extends HibernateSupportDao implements KeywordDao {

	@Override
	public void insert(Keyword keyword) {
		session().save(keyword);
	}

	@Override
	public Keyword select(Long id) {
		return (Keyword)session().get(Keyword.class, id);
	}

	@Override
	public void delete(Keyword keyword) {
		session().delete(keyword);
	}
	
}
