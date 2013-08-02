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
		operate(user, attrKeyword, +1);
	}
	
	public void decrement(User user, AttributeKeyword attrKeyword) {
		operate(user, attrKeyword, -1);
	}
	
	private void operate(User user, AttributeKeyword attrKeyword, Integer operand) {
		Integer val = user.getMajorKeywordRates().get(attrKeyword);
		user.getMajorKeywordRates().put(attrKeyword, val + operand);
		
		userDao.update(user);
	}
}
