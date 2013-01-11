package com.solute.test.utils.stub;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.solute.test.utils.suite.AbstractStubWebServerTest;

public class StubWebServerTest extends AbstractStubWebServerTest {
	
	@Test
	public void testNotNull() {
		assertNotNull(super.server);
	}
}
