/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;

/**
 *
 * @author juho
 */
public class TestTemplate<T> {
	protected T testClass;
	
	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		//testClass = injector.getInstance(T);
	}
	
}
