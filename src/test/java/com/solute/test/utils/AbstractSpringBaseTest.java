package com.solute.test.utils;

import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration({ "/META-INF/spring/appServlet/servlet-context.xml", "/META-INF/spring/root-context.xml",
			"/META-INF/spring/test-context.xml" })
public abstract class AbstractSpringBaseTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static long elapsedTime = 0;
	private static final Logger logger = LoggerFactory.getLogger(AbstractSpringBaseTest.class); 
	@Rule public MethodRule watchman = new TestWatchman() {
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
			logger.error(method.getName()+" error!!", e);
			super.failed(e, method);
		}

		@Override
		public void finished(FrameworkMethod method) {
			logger.info("{} being finished..(time:{})", method.getName(), System.nanoTime() - elapsedTime);
			super.finished(method);
		}
	    
	  };
	  
	protected <T> T createSpringMock(final Class<T> cls) {
		return mock(cls, new Answer<Object>() {
			private T bean = applicationContext.getBean(cls);
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				return invocation.getMethod().invoke(bean, invocation.getArguments());
			}
			
		});
	}
}
