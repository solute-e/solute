package org.springframework.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.solute.test.utils.suite.AbstractSpringBaseTest;

public class TilesViewTest extends AbstractSpringBaseTest {
	private @Autowired TilesViewResolver tilesViewResolver;
	
	@Test
	public void testNotNull() {
		assertNotNull(tilesViewResolver);
	}
	
}
