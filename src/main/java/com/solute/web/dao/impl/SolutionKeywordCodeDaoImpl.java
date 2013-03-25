package com.solute.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solute.entity.SolutionKeywordCode;
import com.solute.web.dao.SolutionKeywordCodeDao;

@Repository
public class SolutionKeywordCodeDaoImpl implements SolutionKeywordCodeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(SolutionKeywordCode skc) {
		sessionFactory.getCurrentSession().save(skc);
	}

	@Override
	public List<SolutionKeywordCode> selectAll() {
		return sessionFactory.getCurrentSession().createCriteria(SolutionKeywordCode.class).list();
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.byId(SolutionKeywordCode.class).getReference(id));
	}
	
}
