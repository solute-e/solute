package com.solute.web.service;

import com.solute.entity.Problem;
import com.solute.entity.User;

public class SolvingService {
	public static class NotImplementedException extends RuntimeException {
	}
	
	public void solve(User user, Problem problem) {
		throw new NotImplementedException();
	}
}
