package com.solute.dao;

import org.springframework.stereotype.Service;

import com.solute.entity.Problem;
import com.solute.entity.User;
import com.solute.utils.HibernateSupportDao;

@Service
public class ProblemDao extends HibernateSupportDao {
	public Problem select(Long id) {
		return (Problem)session().get(Problem.class, id);
	}
	
	public void delete(Problem problem) {
		session().delete(problem);
	}

	public void update(Problem problem) {
		session().saveOrUpdate(problem);
	}
}
