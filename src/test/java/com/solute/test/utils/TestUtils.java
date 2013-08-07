package com.solute.test.utils;

import java.util.HashSet;
import java.util.Set;

import com.solute.entity.AttributeKeyword;
import com.solute.entity.Keyword;
import com.solute.entity.Problem;
import com.solute.entity.User;

public class TestUtils {
	public static final String TOKEN = "LOG";
	
	
	public static <T> Set<T> toSet(T ...elements) {
		Set<T> set = new HashSet<T>();
		for (T elem : elements) {
			set.add(elem);
		}
		
		return set;
	}
	
	public static <T> T[] toArray(Set<T> elementSet) {
		return (T[])elementSet.toArray();
	}
	
	public static Keyword getKeyword() {
		Keyword keyword = new Keyword();
		keyword.setToken(TOKEN);
		
		return keyword;
	}
	
	public static AttributeKeyword getAttributeKeyword() {
		AttributeKeyword ak = new AttributeKeyword();
		ak.setDefaultRate(20.0);
		ak.getKeywords().add(getKeyword());
		
		return ak;
	}
	
	public static User getUser() {
		User user = new User();
		user.setId("dennis");
		
		return user;
	}

	public static Problem getProblem() {
		Problem problem = new Problem();
		problem.setId(0L);
		problem.getRates().put(getAttributeKeyword(), 30.0);
		
		return problem;
	}
}
