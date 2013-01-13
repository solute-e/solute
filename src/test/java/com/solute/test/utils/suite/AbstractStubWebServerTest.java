package com.solute.test.utils.suite;

import com.solute.test.utils.stub.StubWebServer;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.MethodRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractStubWebServerTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());

    protected static final int PORT = 8080;
	protected StubWebServer server;
	
	@Rule
	public MethodRule rule = new ExternalResource() {
		public void before() {
			try {
				server = new StubWebServer();
				server.serve(PORT);
			} catch(Exception e) {
				logger.error(e.getMessage(), e);
				throw new RuntimeException();
			}
		}
		
		public void after() {
			try {
				server.stop();
			} catch(Exception e) {
				logger.error(e.getMessage(), e);
				throw new RuntimeException();
			}
		}
	};
}
