package com.solute.dao;

import static com.solute.test.utils.TestUtils.getAttributeKeyword;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.User;
import com.solute.test.utils.TestUtils;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class UserDaoTest extends AbstractSpringBaseContextTest {

	private static final Double RATE = 20.0;
	private User user;
	
	@Autowired
	private UserDao dao;

	@Before
	public void setUp() {
		user = TestUtils.getUser();
	}
	
	@Test
	public void testDefaultUser() {
		dao.update(user);
		User actual = dao.select(user.getId());
		
		Assert.assertEquals(user, actual);
	}
	
	@Test
	public void testRate() {
		dao.update(user);
		User actual = dao.select(user.getId());
		
		Assert.assertEquals(RATE, actual.getRates().get(getAttributeKeyword()));
	}
	
	@Test
	public void testUpdateRate() {
		dao.update(user);
		User expected = dao.select(user.getId());
		
		expected.getRates().put(getAttributeKeyword(), expected.getRates().get(getAttributeKeyword()) + 1);
		dao.update(expected);
		
		User actual = dao.select(user.getId());
		Assert.assertEquals(expected.getRates().get(getAttributeKeyword()), actual.getRates().get(getAttributeKeyword()));
		Assert.assertEquals(expected, actual);
	}
}
