package com.solute.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solute.dao.ProblemDao;
import com.solute.entity.AttributeKeyword;
import com.solute.entity.Problem;

@Service
public class ProblemService {
	@Autowired
	private ProblemDao problemDao;
	
	public void increment(Problem problem, AttributeKeyword attrKeyword) {
		operate(problem, attrKeyword, +1);
	}
	
	public void decrement(Problem problem, AttributeKeyword attrKeyword) {
		operate(problem, attrKeyword, -1);
	}
	
	private void operate(Problem problem, AttributeKeyword attrKeyword, Integer operand) {
		Integer val = problem.getMajorKeywordRates().get(attrKeyword);
		problem.getMajorKeywordRates().put(attrKeyword, val + operand);
		
		problemDao.update(problem);
	}
}
