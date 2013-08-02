package com.solute.dao;

import com.solute.entity.User;

public interface UserDao {
	User select(String id);
	void delete(User user);
	void update(User user);
}
