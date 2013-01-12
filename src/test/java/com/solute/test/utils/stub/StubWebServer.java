package com.solute.test.utils.stub;

import static org.junit.Assert.assertNotNull;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class StubWebServer {
	private Server server;
	
	public void serve(int port) throws Exception {
		try {
			Server server = new Server(port);
			 
	        WebAppContext context = new WebAppContext();
	        context.setDescriptor("src/main/webapp/WEB-INF/web-dev.xml");
	        context.setResourceBase("src/main/webapp");
	        context.setContextPath("/solute");
//	        context.setParentLoaderPriority(true);
	 
	        server.setHandler(context);
	 
	        server.start();
		} finally {
			assertNotNull(server);
		}
	}
	
	public void stop() throws Exception {
		if (server != null) 
			server.stop();
	}
}
