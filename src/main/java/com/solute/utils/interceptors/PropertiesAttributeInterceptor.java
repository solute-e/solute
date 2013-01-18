package com.solute.utils.interceptors;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PropertiesAttributeInterceptor extends HandlerInterceptorAdapter {
	
	private static final String ATTR_EXISTS_FLAG = "ATTR_IS_EXISTS";
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private URL propertiesFile;
	private String encoding;
	
	private Map<String, String> properties;
	
	public void setPropertiesFile(URL propertiesFile) {
		this.propertiesFile = propertiesFile;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public URL getPropertiesFile() {
		return propertiesFile;
	}

	public String getEncoding() {
		return encoding;
	}

	public void initProperties() throws IllegalArgumentException, UnsupportedEncodingException, IOException {
		if (propertiesFile == null)
			throw new IllegalArgumentException("properties File is null");
		
		this.properties = new HashMap<String, String>();
		Properties properties = new Properties();
		Reader reader = null;
		try {
			reader = new InputStreamReader(propertiesFile.openStream(), encoding);
			properties.load(reader);
			
			for (Object key : properties.keySet()) {
				this.properties.put(key.toString(), properties.getProperty(key.toString()));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (properties == null) {
			initProperties();
			logger.debug("++ properties loaded");
		}
		
		if (request.getAttribute(ATTR_EXISTS_FLAG) == null) {
			request.setAttribute(ATTR_EXISTS_FLAG, true);
			for (String key : this.properties.keySet()) {
				request.setAttribute("attr_" + key, this.properties.get(key));
			}
		}
		return true;
	}
	
	
	
}
