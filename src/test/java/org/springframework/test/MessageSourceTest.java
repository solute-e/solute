package org.springframework.test;

import com.solute.test.utils.suite.AbstractSpringBaseContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class MessageSourceTest extends AbstractSpringBaseContextTest {
	@Autowired
	private MessageSource messageSource;
	
	@Test
	public void testGetMessage() {
		String msg = messageSource.getMessage("test.hello", new Object[]{"me"}, Locale.ENGLISH);
		
		assertEquals("헬로월드 me", msg);
	}
}
