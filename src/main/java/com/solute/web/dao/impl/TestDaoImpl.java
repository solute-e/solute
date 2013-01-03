package com.solute.web.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solute.web.dao.TestDao;
import com.solute.web.entity.TestEcho;

@Repository
public class TestDaoImpl implements TestDao {
	
	private @Autowired SessionFactory sessionFactory;
	
	public void saveTestEcho(TestEcho testEcho) {
		sessionFactory.getCurrentSession().save(testEcho);
	}

	@Override
	public List<TestEcho> listTestEcho() {
		return (List<TestEcho>)sessionFactory.getCurrentSession().createCriteria(TestEcho.class).list();
	}

	@Override
	public TestEcho getTestEchoById(String id) {
		return (TestEcho)sessionFactory.getCurrentSession().get(TestEcho.class, id);
	}
	
}
