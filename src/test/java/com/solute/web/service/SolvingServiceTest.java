package com.solute.web.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.Problem;
import com.solute.entity.User;

public class SolvingServiceTest {
	@Autowired
	private SolvingService solvingService;
	
	@Test
	public void testSolve() {
		User user;
		Problem problem;
		
//		solvingService.solve(user, problem);
	}
}
