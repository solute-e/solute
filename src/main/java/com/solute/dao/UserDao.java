package com.solute.dao;

import com.solute.entity.User;

public interface UserDao {
	User select(Long id);
	void insert(User user);
	void delete(User user);
	void update(User user);
}
