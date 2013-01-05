package com.solute.web.controller;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.solute.utils.view.ThriftView;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration({ "classpath:/META-INF/spring/root-context.xml", "classpath:/META-INF/spring/test-context.xml",
		"classpath:/META-INF/spring/hibernate-context.xml", "classpath:/META-INF/spring/config-context.xml",
		"classpath:/META-INF/spring/appServlet/servlet-context.xml" })
public class ThriftControllerTest {

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
