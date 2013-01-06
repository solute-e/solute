package com.solute.utils.interceptors;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AttributeInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(AttributeInterceptor.class);
	
	private @Autowired ServletContext sc;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String cp = sc.getContextPath();
		Locale locale = request.getLocale();
		
		request.setAttribute("webappRoot", cp);
		request.setAttribute("lang", locale.getLanguage());
		
		return super.preHandle(request, response, handler);
	}
	
	
}
