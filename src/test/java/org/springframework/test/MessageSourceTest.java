package org.springframework.test;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.solute.test.utils.suite.AbstractSpringBaseTest;

public class MessageSourceTest extends AbstractSpringBaseTest {
	@Autowired
	private MessageSource messageSource;
	
	@Test
	public void testGetMessage() {
		String msg = messageSource.getMessage("test.hello", new Object[]{"me"}, Locale.ENGLISH);
		
		assertEquals("헬로월드 me", msg);
	}
}
