package com.solute.dao.impl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.solute.dao.SolutionKeywordDao;
import com.solute.entity.SolutionKeyword;
import com.solute.utils.HibernateSupportDao;

@Repository
public class SolutionKeywordDaoImpl extends HibernateSupportDao implements SolutionKeywordDao {

	@Override
	public void insert(SolutionKeyword sk) {
		session().save(sk);
	}

	@Override
	public List<SolutionKeyword> select() {
		return session().createCriteria(SolutionKeyword.class).list();
	}
	
	public long count() {
		return (Long)session().createCriteria(SolutionKeyword.class).setProjection(Projections.rowCount()).list().get(0);
	}
}
