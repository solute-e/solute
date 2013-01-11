package com.solute.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.solute.utils.annotation.ThriftService;
import com.solute.utils.view.ThriftView;

@Controller
public class ThriftController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Map<String, TProcessor> thriftProcessors = new HashMap<String, TProcessor>();
	private @Autowired ApplicationContext context;
	
	@RequestMapping(value="/thrift/${name}", method=RequestMethod.POST)
	public View getThriftService(@PathVariable String name) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InterruptedException {
		if (!thriftProcessors.containsKey(name)) {
			synchronized(thriftProcessors) {
				if (!thriftProcessors.containsKey(name)) {
					TProcessor processor = constructThriftProcessor(context.getBean(name));
					thriftProcessors.put(name, processor);
				}
			}
		}
		
		return new ThriftView(thriftProcessors.get(name));
	}
	
	private TProcessor constructThriftProcessor(Object service) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		ThriftService thriftServiceAnnotation = AnnotationUtils.findAnnotation(service.getClass(), ThriftService.class);
		if (thriftServiceAnnotation != null) {
			for (Class<?> serviceInterface : service.getClass().getInterfaces()) {
				if (serviceInterface.getName().endsWith("Iface")) { // ***$Iface  와 같은 이름을 갖게 되기 때문에
					for (Class<?> declaredClass : serviceInterface.getEnclosingClass().getDeclaredClasses()) {
						if (declaredClass.getName().endsWith("Processor")) { /// ****$Processor 와 같은 이름을 갖게 됨.
							Object processor = declaredClass.getConstructor(serviceInterface).newInstance(service);
							return TProcessor.class.cast(processor);
						}
					}
					throw new ClassNotFoundException();
				}
			}
		} else {
			throw new IllegalArgumentException("service is annotated ThriftService");
		}
		
		throw new IllegalArgumentException("service is not extended Iface of Thrift");
	}
}
