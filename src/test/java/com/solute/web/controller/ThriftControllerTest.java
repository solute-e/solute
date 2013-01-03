package com.solute.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.solute.test.utils.suite.AbstractSpringBaseTest;

@ActiveProfiles("dev")
@ContextConfiguration({ "/META-INF/spring/root-context.xml", "/META-INF/spring/test-context.xml",
		"/META-INF/spring/hibernate-context.xml", "/META-INF/spring/config-context.xml" })
public class ThriftControllerTest extends AbstractSpringBaseTest {
	
	@Autowired
	private ThriftController controller;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private DispatcherServlet dispatcher;
	private MockServletContext context;

	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		context = new MockServletContext();

		MockServletConfig config = new MockServletConfig("/");
		config.addInitParameter("contextConfigLocation", "classpath:/META-INF/spring/appServlet/servlet-context.xml");

		dispatcher = new DispatcherServlet();
		dispatcher.init(config);
	}

	@Test
	public void testGetThriftService() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		AnnotationMethodHandlerAdapter handlerAdpt = new AnnotationMethodHandlerAdapter();
		request.setRequestURI("/thrift/test");
		ModelAndView mav = handlerAdpt.handle(request, response, this.controller);
		
		assertEquals("Incorrect view name returned", "ThriftView", mav.getViewName());
	}
}
