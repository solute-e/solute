package com.solute.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solute.dao.SolutionKeywordCodeDao;
import com.solute.entity.SolutionKeywordCode;
import com.solute.utils.HibernateSupportDao;

@Repository
public class SolutionKeywordCodeDaoImpl extends HibernateSupportDao implements SolutionKeywordCodeDao {

	@Override
	public void insert(SolutionKeywordCode skc) {
		session().save(skc);
	}
	
	public long count() {
		return (Long)session().createCriteria(SolutionKeywordCode.class)
				.setProjection(Projections.rowCount()).list().get(0);
	}

	@Override
	public List<SolutionKeywordCode> select() {
		return session().createCriteria(SolutionKeywordCode.class).list();
	}

	@Override
	public void delete(Long id) {
		Session session = session();
		SolutionKeywordCode skc = (SolutionKeywordCode)session.load(SolutionKeywordCode.class, id);
		session.delete(skc);
	}
	
}
