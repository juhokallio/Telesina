/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.core.Telesina;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class HandSimulatorTest {

	HandSimulator handSimulator;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		handSimulator = injector.getInstance(HandSimulator.class);
	}

	@Test
	public void simulatorTest1() {
		int[] cards = {0, 8, 1, 9};
		TelesinaHand hand = new TelesinaHand(cards);
		int value = handSimulator.getValue(hand);
		Assert.assertTrue(value >= Telesina.TWO_PAIR_VALUE);
	}
	@Test
	public void simulatorTest2() {
		
		int[] h1 = {2,6,8,11,18};
		int value = handSimulator.getValue(new TelesinaHand(h1), 1);
		Assert.assertTrue(value > 0);
	}
}
