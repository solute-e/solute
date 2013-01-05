package com.solute.test.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solute.test.dao.TestDao;
import com.solute.web.entity.TestEntity;

@Repository
public class TestDaoImpl implements TestDao {
	
	private @Autowired SessionFactory sessionFactory;

	public void save(TestEntity testEntity) {
		sessionFactory.getCurrentSession().save(testEntity);
	}

	public List<TestEntity> list() {
		return (List<TestEntity>)sessionFactory.getCurrentSession().createCriteria(TestEntity.class).list();
	}

}
