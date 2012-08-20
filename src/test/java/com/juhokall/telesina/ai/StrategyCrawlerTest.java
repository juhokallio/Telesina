/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.SolutionType;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class StrategyCrawlerTest {
	StrategyCrawler crawler;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		crawler = injector.getInstance(StrategyCrawler.class);
	}

	@Test
	public void tacticCrawlerTest1() {
		Situation situation = new Situation(2);
		situation.setStreet(2);
		situation.setPotSize(10);
		int value = crawler.valueTactic(situation, 1, SolutionType.FOLD);
		Assert.assertEquals(-10, value);
	}
}
