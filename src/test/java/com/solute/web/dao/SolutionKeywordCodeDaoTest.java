package com.solute.web.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.solute.entity.SolutionKeywordCode;
import com.solute.test.utils.suite.AbstractSpringBaseTestSuite;

public class SolutionKeywordCodeDaoTest extends AbstractSpringBaseTestSuite {
	@Autowired
	private SolutionKeywordCodeDao dao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private SolutionKeywordCode []skcs;
	
	@Before
	public void setUp() {
		dao.deleteAll();
		skcs = new SolutionKeywordCode[]{
				new SolutionKeywordCode("test0"),
				new SolutionKeywordCode("test1"),
				new SolutionKeywordCode("test2"),
				new SolutionKeywordCode("test3"),
				new SolutionKeywordCode("test4")
		};
		
		
		List<SolutionKeywordCode> skcList = dao.selectAll();
		Assert.assertEquals(0, skcList.size());
	}
	
	@After
	public void tearDown() {
		dao.deleteAll();
	}
	
	@Test
	public void testInsert() {
		dao.insert(skcs[0]);
		assertEquals(skcs[0], dao.selectAll().get(0));
	}
}
