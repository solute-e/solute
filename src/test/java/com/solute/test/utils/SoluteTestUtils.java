package com.solute.test.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SoluteTestUtils {
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
}
