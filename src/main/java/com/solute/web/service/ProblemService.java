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
		operate(problem, attrKeyword, +1.0);
	}
	
	public void decrement(Problem problem, AttributeKeyword attrKeyword) {
		operate(problem, attrKeyword, -1.0);
	}
	
	private void operate(Problem problem, AttributeKeyword attrKeyword, Double operand) {
		Double val = problem.getRates().get(attrKeyword);
		problem.getRates().put(attrKeyword, val + operand);
		
		problemDao.update(problem);
	}
}
