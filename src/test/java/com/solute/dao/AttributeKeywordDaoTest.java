package com.solute.dao;

import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.AttributeCode;
import com.solute.entity.AttributeKeyword;
import com.solute.entity.Keyword;
import com.solute.test.utils.TestUtils;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class AttributeKeywordDaoTest extends AbstractSpringBaseContextTest {
	
	@Autowired
	private AttributeKeywordDao dao;
	
	private Keyword []keywords = ArrayUtils.toArray(
			new Keyword(1L, "test"),
			new Keyword(2L, "test2"),
			new Keyword(3L, "test3")
	);
	
	private AttributeKeyword []attributeKeywords = ArrayUtils.toArray(
			new AttributeKeyword(1L, AttributeCode.RECOGNITION, 20.0),
			new AttributeKeyword(2L, AttributeCode.KNOWLEDGE, 30.0),
			new AttributeKeyword(3L, AttributeCode.RECOGNITION, 41.0)
	);
	
	@Before
	public void setUp() {
		for (AttributeKeyword keyword : attributeKeywords) {
			keyword.setKeywords(TestUtils.toSet(keywords));
			dao.update(keyword);
		}
	}
	
	@Test
	public void testKeywords() {
		for (AttributeKeyword keyword : attributeKeywords) {
			AttributeKeyword actual = dao.select(keyword.getId());
			Assert.assertEquals(actual, keyword);
		}
	}
	
	@Test
	public void testDeletes() {
		for (AttributeKeyword keyword : attributeKeywords) {
			dao.delete(keyword);
			Assert.assertNull(dao.select(keyword.getId()));
		}
	}
	
	@Test
	public void testGetKeywords() {
		AttributeKeyword keyword = dao.select(attributeKeywords[0].getId());
		Set<Keyword> keywordSet = keyword.getKeywords();
		for (Keyword kw : keywords) {
			Assert.assertTrue(keywordSet.contains(kw));
		}
	}
}
