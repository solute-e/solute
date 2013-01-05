package com.solute.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration({ "/META-INF/spring/root-context.xml", "/META-INF/spring/test-context.xml",
		"/META-INF/spring/hibernate-context.xml", "/META-INF/spring/config-context.xml", "/META-INF/spring/appServlet/servlet-context.xml" })
public class ThriftControllerTest {
	
	@Autowired
	private ThriftController controller;
	
	@Autowired 
	private MockServletContext sc;
	
	private DispatcherServlet dispatcher;

	@Before
	public void setUp() throws Exception {
		MockServletConfig config = new MockServletConfig(sc, "dispatcher");
		config.addInitParameter("contextConfigLocation", "classpath:/META-INF/spring/appServlet/servlet-context.xml");

		dispatcher = new DispatcherServlet();
		dispatcher.init(config);
	}

	@Test
	public void testGetThriftService() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		AnnotationMethodHandlerAdapter handlerAdpt = new AnnotationMethodHandlerAdapter();
		request.setMethod("POST");
		request.setRequestURI("/thrift/test");
		ModelAndView mav = handlerAdpt.handle(request, response, this.controller);
		
		assertEquals("Incorrect view name returned", "ThriftView", mav.getViewName());
	}
}
