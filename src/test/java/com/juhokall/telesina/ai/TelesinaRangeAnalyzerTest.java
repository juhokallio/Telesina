/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerTest {
	
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
}
