package com.solute.web.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.dao.UserDao;
import com.solute.entity.User;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

import static org.junit.Assert.assertEquals;

import static com.solute.test.utils.TestUtils.getAttributeKeyword;
import static com.solute.test.utils.TestUtils.getUser;

public class UserServiceTest extends AbstractSpringBaseContextTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	private User user;

	@Before
	public void setUp() throws Exception {
		user = getUser();
		userDao.update(user);
	}
	
	@Test
	public void testIncrement() {
		Double expected = user.getRates().get(getAttributeKeyword()) + 1.0;
		userService.increment(user, getAttributeKeyword());
		Double actual = userDao.select(user.getId()).getRates().get(getAttributeKeyword()); 
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testDecrement() {
		Double expected = user.getRates().get(getAttributeKeyword()) - 1;
		userService.decrement(user, getAttributeKeyword());
		Double actual = userDao.select(user.getId()).getRates().get(getAttributeKeyword()); 
		
		assertEquals(expected, actual, 0.001);
	}
}
