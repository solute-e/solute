package com.solute.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateSupportDao {
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session session() {
		return sessionFactory.getCurrentSession();
	}
}
