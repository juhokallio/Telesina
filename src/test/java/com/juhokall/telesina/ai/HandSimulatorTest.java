/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Telesina;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.TelesinaValuedCard;
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
		TelesinaValuedCard valuedCard = handSimulator.getValuedCard(hand);
		System.out.println("value: " + valuedCard.getValue());
		Assert.assertTrue(valuedCard.getValue() >= Telesina.TWO_PAIR_VALUE);
	}
}