package com.solute.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solute.K;
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
			double userNewRate = R(userRate, problemRate, user_s);
			double problemNewRate = R(problemRate, userRate, problem_s);
			
			userRates.put(attributeKeyword, userNewRate);
			problemRates.put(attributeKeyword, problemNewRate);
		}
		
		userDao.update(user);
		problemDao.update(problem);
	}
	
	private double R(double R1, double R2, double S) {
		double E1 = E(R1, R2);
		return R_(R1, E1, S);
	}
	
	private double R_(double R, double E, double S) {
		return R + K.value() * (S - E);
	}
	
	private double E(double R1, double R2) {
		return 1.0/(1 + Math.pow(10.0, (R1 - R2)/400.0));
	}
	
}
