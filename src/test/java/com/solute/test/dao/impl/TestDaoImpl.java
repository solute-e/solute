package com.solute.test.dao.impl;

import com.solute.test.dao.TestDao;
import com.solute.web.entity.TestEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
