/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.HandRange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class RangeComparatorTest {

	private RangeComparator rangeComparator;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		rangeComparator = injector.getInstance(RangeComparator.class);
	}

	@Test
	public void comparatorTest1() {
		HandRange range1 = new HandRange();
		HandRange range2 = new HandRange();
		range1.addValue(10);
		range2.addValue(30);
		double percentage = rangeComparator.getEquity(range1, range2);
		Assert.assertEquals(0, percentage, 0.001);
	}

	@Test
	public void comparatorTest2() {
		HandRange range1 = new HandRange();
		HandRange range2 = new HandRange();
		range1.addValue(10);
		range2.addValue(30);
		double percentage = rangeComparator.getEquity(range2, range1);
		Assert.assertEquals(1, percentage, 0.001);
	}

	@Test
	public void comparatorTest3() {
		HandRange range1 = new HandRange();
		HandRange range2 = new HandRange();
		for (int i = 0; i < 999; i++) {
			range1.addValue(10);
			range1.addValue(40);
			range2.addValue(37);
			range2.addValue(35);
		}
		range2.sortValues();
		range1.sortValues();
		double percentage = rangeComparator.getEquity(range1, range2);
		Assert.assertEquals(0.5, percentage, 0.05);
	}
}
