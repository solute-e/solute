package com.solute.dao;

import org.springframework.stereotype.Repository;

import com.solute.entity.User;
import com.solute.utils.HibernateSupportDao;

@Repository
public class UserDao extends HibernateSupportDao {

	public User select(String id) {
		return (User)session().get(User.class, id);
	}

	public void delete(User user) {
		session().delete(user);
	}

	public void update(User user) {
		session().saveOrUpdate(user);
	}
}
