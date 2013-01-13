package com.solute.utils.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class AttributeInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(AttributeInterceptor.class);
	
	private @Autowired ServletContext sc;
	private @Autowired CookieLocaleResolver localeResolver;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String cp = sc.getContextPath();
		Locale locale = localeResolver.resolveLocale(request);
		
		request.setAttribute("webappRoot", cp);
		request.setAttribute("lang", locale.getLanguage());
		
		return super.preHandle(request, response, handler);
	}
	
	
}
