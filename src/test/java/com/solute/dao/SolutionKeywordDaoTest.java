package com.solute.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.SolutionKeyword;
import com.solute.entity.SolutionKeywordCode;
import com.solute.test.utils.suite.AbstractSpringBaseContextsTest;

public class SolutionKeywordDaoTest extends AbstractSpringBaseContextsTest {
	@Autowired
	private SolutionKeywordDao dao;
	
	private SolutionKeywordCodeDaoTest skcDaoTest;
	
	private SolutionKeyword[] sks;
	
	@Before
	public void setUp() {
		
		sks = new SolutionKeyword[skcDaoTest.getSkcs().length];
		int i = 0;
		for (SolutionKeywordCode skc : skcDaoTest.getSkcs()) {
			sks[i++] = new SolutionKeyword(skc.getId());
		}
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testInsert() {
		
	}
}
