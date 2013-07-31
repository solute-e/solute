package com.solute.dao;

import junit.framework.Assert;
import static com.solute.test.utils.TestUtils.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.AttributeKeyword;
import com.solute.entity.Keyword;
import com.solute.entity.User;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class UserDaoTest extends AbstractSpringBaseContextTest {

	private static final Integer RATE = 20;
	private User user;
	
	@Autowired
	private UserDao dao;

	@Before
	public void setUp() {
		user = new User();
		user.setUserId("dennis");
		user.getRate().put(getAttributeKeyword(), RATE);
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
		
		Assert.assertEquals(RATE, actual.getRate().get(getAttributeKeyword()));
	}
	
	@Test
	public void testUpdateRate() {
		dao.update(user);
		User expected = dao.select(user.getId());
		
		expected.getRate().put(getAttributeKeyword(), expected.getRate().get(getAttributeKeyword()) + 1);
		dao.update(expected);
		
		User actual = dao.select(user.getId());
		Assert.assertEquals(expected.getRate().get(getAttributeKeyword()), actual.getRate().get(getAttributeKeyword()));
		Assert.assertEquals(expected, actual);
	}
}
