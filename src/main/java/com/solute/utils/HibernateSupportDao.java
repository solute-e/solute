package com.solute.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateSupportDao {
	protected @Autowired SessionFactory sessionFactory;
	
	protected Session session() {
		try {
			return sessionFactory.getCurrentSession();
		} catch(HibernateException e) {
			return sessionFactory.openSession();
		}
	}
}
