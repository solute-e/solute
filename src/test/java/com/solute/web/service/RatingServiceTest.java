package com.solute.web.service;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class RatingServiceTest extends AbstractSpringBaseContextTest {
	@Autowired
	private UserService service;
	
//	private User user;
//	private Problem problem;
	
	private Map kwMap = ArrayUtils.toMap(new Object[][] {
			{"matrix", 1L},
			{"multiply", 2L},
			{"matrix multiply", 3L}
	});
	
	
	@Test
	public void testIncrement() {
		
	}
	
	@Test
	public void testDescrement() {
		
	}
}
