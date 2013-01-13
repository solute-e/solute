package com.solute.web.controller;

import com.solute.test.utils.suite.AbstractSpringBaseTest;
import com.solute.utils.view.ThriftView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertNotNull;

public class ThriftControllerTest extends AbstractSpringBaseTest {

	@Autowired
	private ThriftController controller;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() {
		assertNotNull(applicationContext);
		assertNotNull(controller);
	}
	
	@Test
	public void testMockGetThrift() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InterruptedException {
		ThriftView thriftView = (ThriftView) controller.getThriftService("test");
		assertNotNull(thriftView);
	}
}
