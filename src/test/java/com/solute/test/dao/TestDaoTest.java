package com.solute.test.dao;

import com.solute.test.dao.impl.TestDaoImpl;
import com.solute.test.utils.suite.AbstractSpringBaseTest;
import com.solute.web.entity.TestEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

public class TestDaoTest extends AbstractSpringBaseTest {
	
	private @Mock SessionFactory sessionFactory ;
	private @Autowired TestDao testDao;
	
	private @Mock Session session;
	private @Mock Criteria criteria;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		
		when(sessionFactory.getCurrentSession()).thenAnswer(new Answer<Session>() {
			public Session answer(InvocationOnMock invocation) throws Throwable {
				when(session.createCriteria(TestEntity.class)).thenReturn(criteria);
				
				return session;
			}
		});
		
		Field sessionFactoryField = ReflectionUtils.findField(TestDaoImpl.class, "sessionFactory");
		ReflectionUtils.makeAccessible(sessionFactoryField);
		ReflectionUtils.setField(sessionFactoryField, testDao, sessionFactory);
	}
	
	@Test
	public void testList() {
		testDao.list();
		
		verify(session).createCriteria(TestEntity.class);
		verify(criteria).list();
		reset(session, criteria);
		
	}
	
}
