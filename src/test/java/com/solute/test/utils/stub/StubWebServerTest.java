package com.solute.test.utils.stub;

import com.solute.test.utils.suite.AbstractStubWebServerTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StubWebServerTest extends AbstractStubWebServerTest {
	
	@Test
	public void testNotNull() {
		assertNotNull(super.server);
    }
}
