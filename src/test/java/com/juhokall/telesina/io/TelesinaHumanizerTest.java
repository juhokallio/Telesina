/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.google.inject.Guice;
import com.google.inject.Injector;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaHumanizerTest {

	TelesinaHumanizer humanizer;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		humanizer = injector.getInstance(TelesinaHumanizer.class);
	}

	@Test
	public void TelesinaHumanizerTest1() {
		int card = 0;
		String humanizedCard = humanizer.humanizeCard(card);
		Assert.assertEquals("7S", humanizedCard);	
	}
	@Test
	public void TelesinaHumanizerTest2() {
		int card = 31;
		String humanizedCard = humanizer.humanizeCard(card);
		Assert.assertEquals("AH", humanizedCard);	
	}
	@Test
	public void TelesinaHumanizerTest3() {
		int card = 32;
		String humanizedCard = humanizer.humanizeCard(card);
		Assert.assertEquals("NN", humanizedCard);	
	}
	
	@Test
	public void TelesinaHumanizerTest4() {
		int card = -32;
		String humanizedCard = humanizer.humanizeCard(card);
		Assert.assertEquals("NN", humanizedCard);	
	}
	@Test
	public void TelesinaHumanizerTest5() {
		int card = 1;
		String humanizedCard = humanizer.humanizeCard(card);
		Assert.assertEquals("8S", humanizedCard);	
	}

}
