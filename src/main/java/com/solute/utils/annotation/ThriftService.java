/**
 * 
 */
package com.solute.utils.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author jcooky
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ThriftService {
	String value();
}
