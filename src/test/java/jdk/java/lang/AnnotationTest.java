package jdk.java.lang;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Anno {
	public String value() default "value";
}

public class AnnotationTest {
	
	@Anno("A class")
	private class A {
		private Anno anno;
		
		public String getValue() {
			return anno.value();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void testA() {
		A a = new A();
		assertEquals("A class", a.getValue());
	}
	
	private class B {
		private Anno anno;
		
		public String getValue() {
			return anno.value();
		}
	}
	
	@Anno("C class")
	private class C {
		private A a = new A();
		
		public String getValue() {
			return a.getValue();
		}
	}
	
	@Test
	public void testB() {
		B b = new B();
		
		assertEquals("C class", b.getValue());
	}
}
