package com.solute.test.utils.suite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

public class ConfigurableDispatcherServlet  extends DispatcherServlet{

	
	
	/*
	 * 클래스 , xml 을 지원할수 있도록
	*/
	private Class<?>[] classes;
	private String[] locations;
	private String []activeProfiles;
	
	private ModelAndView modelAndView;
	
	public ConfigurableDispatcherServlet(String[] locations) {
		this.locations = locations;
	}
	
	public ConfigurableDispatcherServlet(Class<?> ...classes) {
		this.classes = classes;
	}
	
	public void setLocation(String ...locations) {
		this.locations = locations;
	}
	
	public void setActiveProfiles(String ...activeProfiles) {
		this.activeProfiles = activeProfiles;
	}
	
	public void setRelativeLocation(Class clazz, String ...relativeLocation) {
		String[] locations = new String[relativeLocation.length];
		String currentPath = ClassUtils.classPackageAsResourcePath(clazz) + "/";
		
		for (int i = 0; i < relativeLocation.length; i++) {
			locations[i] = relativeLocation[i];
		}
		this.setLocation(locations);
	}
	
	public void setClasses(Class<?> ...classes){
		this.classes = classes;
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		modelAndView = null;
		super.service(request, response);
	}
	
	protected WebApplicationContext createWebApplicationContext (ApplicationContext parent){
		AbstractRefreshableWebApplicationContext wac = new AbstractRefreshableWebApplicationContext() {
			
			@Override
			protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
					throws BeansException, IOException {

				if(locations != null){
					XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
					xmlReader.loadBeanDefinitions(locations);
				}
				if(classes != null) {
					AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
					reader.register(classes);
				}
				
			}
		};
		
		for (String activeProfile : activeProfiles) {
			wac.getEnvironment().addActiveProfile(activeProfile);
		}
		wac.setServletContext(getServletContext());
		wac.setServletConfig(getServletConfig());
		wac.refresh();
		
		return wac;
	}
	
	protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.modelAndView = mv;
		super.render(mv, request, response);
	}
	
	public ModelAndView getModelAndView() {
		return modelAndView;
	}	
}