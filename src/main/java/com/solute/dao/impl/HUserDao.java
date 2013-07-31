package com.solute.dao.impl;

import org.springframework.stereotype.Repository;

import com.solute.dao.UserDao;
import com.solute.entity.User;
import com.solute.utils.HibernateSupportDao;

@Repository
public class HUserDao extends HibernateSupportDao implements UserDao {

	@Override
	public User select(Long id) {
		return (User)session().get(User.class, id);
	}

	@Override
	public void delete(User user) {
		session().delete(user);
	}

	@Override
	public void update(User user) {
		session().saveOrUpdate(user);
	}
}
