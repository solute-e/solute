package com.solute.web.dao;

import java.util.List;

import com.solute.entity.SolutionKeywordCode;

public interface SolutionKeywordCodeDao {
	public void insert(SolutionKeywordCode skc);
	public List<SolutionKeywordCode> selectAll();
	public void delete(Integer id);
	public void deleteAll();
}
