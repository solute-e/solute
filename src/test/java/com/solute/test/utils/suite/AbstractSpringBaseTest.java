package com.solute.test.utils.suite;

import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runner.RunWith;
import org.junit.runners.model.FrameworkMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"classpath:/META-INF/spring/test/test-context.xml",
		"file:src/main/webapp/WEB-INF/spring/dao-context.xml",
		"file:src/main/webapp/WEB-INF/spring/config-context.xml",
        "file:src/main/webapp/WEB-INF/spring/mvc/servlet-context.xml"})
public abstract class AbstractSpringBaseTest {
	private static long elapsedTime = 0;
	private static Logger logger = LoggerFactory.getLogger(AbstractSpringBaseTest.class);

	@Rule
	public MethodRule watchman = new TestWatchman() {
		public void starting(FrameworkMethod method) {
			logger.info("{} being run...", method.getName());
			elapsedTime = System.nanoTime();
		}

		@Override
		public void succeeded(FrameworkMethod method) {
			logger.info("{} being succeeded...", method.getName());
			super.succeeded(method);
		}

		@Override
		public void failed(Throwable e, FrameworkMethod method) {
			logger.error(method.getName() + " error!!", e);
			super.failed(e, method);
		}

		@Override
		public void finished(FrameworkMethod method) {
			logger.info("{} being finished..(time:{})", method.getName(), System.nanoTime()
					- elapsedTime);
			super.finished(method);
		}

	};

}
