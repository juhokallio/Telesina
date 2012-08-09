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
		Assert.assertEquals(0, handRater.getHighcardValue(0));
	}

@Test
	public void highcardTest2() {
		Assert.assertEquals(4, handRater.getHighcardValue(1));
	}
	@Test
	public void highcardTest3() {
		Assert.assertEquals(1, handRater.getHighcardValue(8));
	}
	@Test
	public void highcardTest4() {
		Assert.assertEquals(5, handRater.getHighcardValue(9));
	}
	@Test
	public void highcardTest5() {
		Assert.assertEquals(3, handRater.getHighcardValue(24));
	}
	@Test
	public void highcardTest6() {
		Assert.assertEquals(2, handRater.getHighcardValue(16));
}
	@Test
	public void pairTest1() {
		int[] hand = {0, 1};
		Assert.assertEquals(0, handRater.getPairhandValue(hand));
}
	@Test
	public void pairTest2() {
		int[] hand1 = {0, 8};
		int[] hand2 = {1, 9};
		Assert.assertTrue(handRater.getPairhandValue(hand1) < handRater.getPairhandValue(hand2));
}
	@Test
	public void twoPairTest1() {
		int[] hand1 = {0, 8, 1, 9};
		int[] hand2 = {2, 10};
		Assert.assertTrue(handRater.getPairhandValue(hand1) > handRater.getPairhandValue(hand2));
}
	@Test
	public void twoPairTest2() {
		int[] hand1 = {0, 8, 3, 11};
		int[] hand2 = {1, 9, 2, 10};
		Assert.assertTrue(handRater.getPairhandValue(hand1) > handRater.getPairhandValue(hand2));
}
	@Test
	public void twoPairTest3() {
		int[] hand1 = {0, 8, 3, 11, 4, 12};
		int[] hand2 = {1, 9, 2, 10, 5, 13};
		Assert.assertTrue(handRater.getPairhandValue(hand1) < handRater.getPairhandValue(hand2));
}
	@Test
	public void twoPairTest4() {
		int[] hand1 = {0, 8, 4, 12, 3, 11};
		int[] hand2 = {1, 9, 2, 10, 5, 13};
		Assert.assertTrue(handRater.getPairhandValue(hand1) < handRater.getPairhandValue(hand2));
}
	@Test
	public void twoPairTest5() {
		int[] hand1 = {3, 11, 0, 8, 4, 12};
		int[] hand2 = {1, 9, 2, 10, 5, 13};
		Assert.assertTrue(handRater.getPairhandValue(hand1) < handRater.getPairhandValue(hand2));
}
	
	
}
