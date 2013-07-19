package com.solute.dao;

import org.springframework.stereotype.Repository;

import com.solute.entity.Keyword;

public interface KeywordDao {
	void insert(Keyword keyword);
	Keyword select(Long id);
	void delete(Keyword keyword);
}
