package com.solute.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solute.dao.UserDao;
import com.solute.entity.AttributeKeyword;
import com.solute.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void increment(User user, AttributeKeyword attrKeyword) {
		operate(user, attrKeyword, +1.0);
	}
	
	public void decrement(User user, AttributeKeyword attrKeyword) {
		operate(user, attrKeyword, -1.0);
	}
	
	private void operate(User user, AttributeKeyword attrKeyword, Double operand) {
		Double val = user.getRates().get(attrKeyword);
		user.getRates().put(attrKeyword, val + operand);
		
		userDao.update(user);
	}
}
