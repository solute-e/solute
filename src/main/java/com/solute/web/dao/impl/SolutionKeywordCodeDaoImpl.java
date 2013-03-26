package com.solute.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solute.entity.SolutionKeywordCode;
import com.solute.utils.HibernateSupportDao;
import com.solute.web.dao.SolutionKeywordCodeDao;

@Repository
public class SolutionKeywordCodeDaoImpl extends HibernateSupportDao implements SolutionKeywordCodeDao {

	@Override
	public void insert(SolutionKeywordCode skc) {
		session().save(skc);
	}

	@Override
	public List<SolutionKeywordCode> selectAll() {
		return session().createCriteria(SolutionKeywordCode.class).list();
	}

	@Override
	public void delete(Integer id) {
		Session session = session();
		SolutionKeywordCode skc = (SolutionKeywordCode)session.load(SolutionKeywordCode.class, id);
		session.delete(skc);
	}
	
	@Override
	public void deleteAll() {
		Session session = session();
		for (SolutionKeywordCode skc : (List<SolutionKeywordCode>)session.createCriteria(SolutionKeywordCode.class).list()) {
			session.delete(skc);
		}
	}
}
