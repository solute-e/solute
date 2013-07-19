package com.solute.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.Keyword;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class KeywordDaoTest extends AbstractSpringBaseContextTest {
	
	@Autowired
	private KeywordDao dao;
	
	private Keyword []keywords = new Keyword[] {
			new Keyword(1L, "test"),
			new Keyword(2L, "test2"),
			new Keyword(3L, "test3")
	};
	
	@Before
	public void setUp() {
		for (Keyword keyword : keywords) {
			dao.insert(keyword);
		}
	}
	
	@Test
	public void testKeywords() {
		for (Keyword keyword : keywords) {
			Keyword actual = dao.select(keyword.getId());
			Assert.assertEquals(actual, keyword);
		}
	}
	
	@Test
	public void testDeletes() {
		for (Keyword keyword : keywords) {
			dao.delete(keyword);
			Assert.assertNull(dao.select(keyword.getId()));
		}
	}
}
