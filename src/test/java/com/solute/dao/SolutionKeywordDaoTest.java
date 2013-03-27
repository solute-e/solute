package com.solute.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.SolutionKeyword;
import com.solute.entity.SolutionKeywordCode;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class SolutionKeywordDaoTest extends AbstractSpringBaseContextTest {
	@Autowired
	private SolutionKeywordDao targetDao;
	
	@Autowired
	private SolutionKeywordCodeDao codeDao;
	
	private SolutionKeyword[] sks;
	private SolutionKeywordCode []skcs;
	
	@Before
	public void setUp() {
		skcs = new SolutionKeywordCode[]{
				new SolutionKeywordCode("test0"),
				new SolutionKeywordCode("test1"),
				new SolutionKeywordCode("test2"),
				new SolutionKeywordCode("test3"),
				new SolutionKeywordCode("test4")
		};
		
		
		
		for (SolutionKeywordCode skc : skcs) {
			codeDao.insert(skc);
		}
		
		List<SolutionKeywordCode> skcs = codeDao.select();
		
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testInsert() {
		
	}
}
