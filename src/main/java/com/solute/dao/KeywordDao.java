package com.solute.dao;

import org.springframework.stereotype.Repository;

import com.solute.entity.Keyword;
import com.solute.utils.HibernateSupportDao;

@Repository
public class KeywordDao extends HibernateSupportDao {

	public void insert(Keyword keyword) {
		session().save(keyword);
	}

	public Keyword select(Long id) {
		return (Keyword)session().get(Keyword.class, id);
	}

	public void delete(Keyword keyword) {
		session().delete(keyword);
	}
	
}
