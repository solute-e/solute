package com.solute.utils.regex;

public class RegexUtils {
	public static final String EMAIL_FORMAT = "([a-z]|[0-9])+@([a-z]|[0-9])+\\.([a-z]|[0-9])+";
	
	public static boolean matchesEmail(String email) {
		return email.matches(EMAIL_FORMAT);
	}
}
