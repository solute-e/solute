package com.solute.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.solute.dao.SolutionKeywordCodeDao;
import com.solute.entity.SolutionKeywordCode;
import com.solute.test.utils.suite.AbstractSpringBaseContextsTest;

public class SolutionKeywordCodeDaoTest extends AbstractSpringBaseContextsTest {
	@Autowired
	private SolutionKeywordCodeDao dao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private SolutionKeywordCode []skcs;
	
	public SolutionKeywordCode[] getSkcs() {
		return skcs;
	}
	
	@Before
	public void setUp() {
		skcs = new SolutionKeywordCode[]{
				new SolutionKeywordCode("test0"),
				new SolutionKeywordCode("test1"),
				new SolutionKeywordCode("test2"),
				new SolutionKeywordCode("test3"),
				new SolutionKeywordCode("test4")
		};
		
		assertEquals(0, dao.select().size());
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testInsert() {
		for (SolutionKeywordCode skc : skcs) {
			dao.insert(skc);
		}
		List<SolutionKeywordCode> skcList = dao.select();
		assertEquals(skcs.length, skcList.size());
		System.out.println(skcList);
		assertArrayEquals(skcs, skcList.toArray(new SolutionKeywordCode[skcList.size()]));
	}
	
	@Test
	public void testDelete() {
		testInsert();
		for (SolutionKeywordCode skc : dao.select()) {
			dao.delete(skc.getId());
		}
		
		List<SolutionKeywordCode> skcList = dao.select();
		assertEquals(0, skcList.size());
	}
	
	@Test
	public void testCount() {
		testInsert();
		assertEquals((long)skcs.length, dao.count());
	}
}
