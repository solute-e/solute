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
		user.setId("dennis");
		user.getMajorKeywordRates().put(getAttributeKeyword(), RATE);
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
		
		Assert.assertEquals(RATE, actual.getMajorKeywordRates().get(getAttributeKeyword()));
	}
	
	@Test
	public void testUpdateRate() {
		dao.update(user);
		User expected = dao.select(user.getId());
		
		expected.getMajorKeywordRates().put(getAttributeKeyword(), expected.getMajorKeywordRates().get(getAttributeKeyword()) + 1);
		dao.update(expected);
		
		User actual = dao.select(user.getId());
		Assert.assertEquals(expected.getMajorKeywordRates().get(getAttributeKeyword()), actual.getMajorKeywordRates().get(getAttributeKeyword()));
		Assert.assertEquals(expected, actual);
	}
}
