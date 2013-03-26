package com.solute.dao;

import java.util.List;

import com.solute.entity.SolutionKeywordCode;

public interface SolutionKeywordCodeDao {
	public void insert(SolutionKeywordCode skc);
	public List<SolutionKeywordCode> select();
	public void delete(Long id);
	public long count();
}
