/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaHandRaterTest extends TelesinaHandRaterImpl {

	TelesinaHandRater handRater;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		handRater = injector.getInstance(TelesinaHandRater.class);
	}

	@Test
	public void highcardTest1() {
		Assert.assertEquals(3, handRater.getHighcardValue(0));
	}

@Test
	public void highcardTest2() {
		Assert.assertEquals(7, handRater.getHighcardValue(1));
	}
	@Test
	public void highcardTest3() {
		Assert.assertEquals(2, handRater.getHighcardValue(8));
	}
	@Test
	public void highcardTest4() {
		Assert.assertEquals(6, handRater.getHighcardValue(9));
	}
	@Test
	public void highcardTest5() {
		Assert.assertEquals(0, handRater.getHighcardValue(24));
	}
	@Test
	public void highcardTest6() {
		Assert.assertEquals(1, handRater.getHighcardValue(16));
}
	
}
