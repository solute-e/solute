package com.solute.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.entity.AttributeKeyword;
import com.solute.entity.Problem;
import com.solute.entity.User;
import com.solute.test.utils.TestUtils;
import com.solute.test.utils.suite.AbstractSpringBaseContextTest;

public class SolvingServiceTest extends AbstractSpringBaseContextTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SolvingService solvingService;
	
	@Test
	public void testSolve() {
		User user = TestUtils.getUser();
		Problem problem = TestUtils.getProblem();
		AttributeKeyword ak = TestUtils.getAttributeKeyword();
		
		double rateSum = ak.getDefaultRate() + problem.getRates().get(ak);
		solvingService.doSolving(user, problem, true);
		solvingService.doSolving(user, problem, false);
		Assert.assertEquals(rateSum, problem.getRates().get(ak) + user.getRates().get(ak), 0.001);
	}
}
