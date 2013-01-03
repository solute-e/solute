package jdk.java.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JavaClassTest {
	public static class A {
		public static interface Enclosing {
			public void methodA();
		}
	}
	
	@Test
	public void testGetEnclosingClass() {
		Class<?> enclosingCls = A.Enclosing.class;
		
		assertEquals(A.class, enclosingCls.getEnclosingClass());
	}
	
	@Test
	public void testGetDeclaredClass() {
		Class<?> cls = A.class;
		
		assertEquals(A.Enclosing.class, cls.getDeclaredClasses()[0]);
	}
}
