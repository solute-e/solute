package jdk.java.lang;

import org.junit.Test;

import java.lang.annotation.*;

import static org.junit.Assert.assertEquals;

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
	
	@Test(expected=NullPointerException.class)
	public void testB() {
		B b = new B();
		
		assertEquals("C class", b.getValue());
	}
}
