package com.solute.test.utils.stub;

import static org.junit.Assert.assertNotNull;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class StubWebServer {
	private Server server;

	public void serve(int port) throws Exception {
		try {
			server = new Server();

			Connector connector = new SelectChannelConnector();
			connector.setPort(port);
			server.setConnectors(new Connector[] { connector });

			WebAppContext context = new WebAppContext();
			context.setDescriptor("src/main/webapp/WEB-INF/web-dev.xml");
			context.setResourceBase("src/main/webapp");
			context.setContextPath("/");
			context.setParentLoaderPriority(true);

			ContextHandlerCollection contexts = new ContextHandlerCollection();
			contexts.setHandlers(new Handler[] { context });

			server.setHandler(contexts);

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
