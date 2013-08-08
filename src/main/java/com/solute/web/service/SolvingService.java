package com.solute.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solute.ELO;
import com.solute.dao.ProblemDao;
import com.solute.dao.UserDao;
import com.solute.entity.AttributeKeyword;
import com.solute.entity.Problem;
import com.solute.entity.User;

@Service
public class SolvingService {
	private static final double WIN = 1.0;
	private static final double LOSE = 0.0;
	
	private @Autowired UserDao userDao;
	private @Autowired ProblemDao problemDao;
	
	public void doSolving(User user, Problem problem, boolean resolved) {
		double user_s = resolved ? WIN : LOSE, problem_s = resolved ? LOSE : WIN;
		
		Map<AttributeKeyword, Double> userRates = user.getRates();
		Map<AttributeKeyword, Double> problemRates = problem.getRates();
		
		for (AttributeKeyword attributeKeyword : problemRates.keySet()) {
			Double userRate = userRates.get(attributeKeyword);
			if (userRate == null)
				userRate = attributeKeyword.getDefaultRate();
			Double problemRate = problemRates.get(attributeKeyword);
			double userNewRate = ELO.R(userRate, problemRate, user_s);
			double problemNewRate = ELO.R(problemRate, userRate, problem_s);
			
			userRates.put(attributeKeyword, userNewRate);
			problemRates.put(attributeKeyword, problemNewRate);
		}
		
		userDao.update(user);
		problemDao.update(problem);
	}
	
	
}
