package com.solute.dao;

import java.util.List;

import com.solute.entity.SolutionKeyword;

public interface SolutionKeywordDao {
	public void insert(SolutionKeyword sk);
	public List<SolutionKeyword> select();
	public long count();
}
