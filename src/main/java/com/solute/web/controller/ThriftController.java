package com.solute.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.thrift.TProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.View;

import com.solute.utils.view.ThriftView;

@Controller
public class ThriftController {
	
	private @Autowired ServletContext sc;
	private Map<String, TProcessor> thriftProcessors = new HashMap<String, TProcessor>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		return "/test/test";
	}
	
	@RequestMapping(value="/thrift/${name}", method=RequestMethod.POST)
	public View getThriftService(@PathVariable String name) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		TProcessor processor = thriftProcessors.get(name);
		if (processor == null) {
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
			processor = constructThriftProcessor(context.getBean(name));
			synchronized(thriftProcessors) {
				thriftProcessors.put(name, processor);
			}
		}
		
		return new ThriftView(processor);
	}
	
	private TProcessor constructThriftProcessor(Object service) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		for (Class<?> serviceInterface : service.getClass().getInterfaces()) {
			if ("Iface".equals(serviceInterface.getName())) {
				for (Class<?> declaredClass : serviceInterface.getEnclosingClass().getDeclaredClasses()) {
					if ("Processor".equals(declaredClass.getName())) {
						Object processor = declaredClass.getConstructor(serviceInterface).newInstance(service);
						return TProcessor.class.cast(processor);
					}
				}
				throw new ClassNotFoundException();
			}
		}
		
		throw new IllegalArgumentException("service is not extended Iface of Thrift");
	}
}
