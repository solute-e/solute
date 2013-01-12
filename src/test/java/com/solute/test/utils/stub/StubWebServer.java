package com.solute.test.utils.stub;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StubWebServer {
	private Server server;
	
	public void serve(int port) throws Exception {
		Server server = new Server(port);
		 
        WebAppContext context = new WebAppContext();
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/solute");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
 
        server.start();
	}
	
	public void stop() throws Exception {
		server.stop();
	}
}
