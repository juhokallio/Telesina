/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import java.util.List;

/**
 *
 * @author juho
 */
public class RangeComparatorImpl implements RangeComparator {
	private static int INCREMENT_COUNT = 20;

	@Override
	public double getEquity(HandRange range1, HandRange range2) {
		List<Integer> values2 = range2.getValues();
		List<Integer> values1 = range1.getValues();
		int index = 0;
		int increment1 = values1.size() / INCREMENT_COUNT;
		int increment2 = values1.size() / INCREMENT_COUNT;
		double beatenValues = 0;
		
		for (int i = 0; i < INCREMENT_COUNT; i++) {
			while (index < INCREMENT_COUNT && values1.get(increment1 * i) > values2.get(index * increment2)) {
				index++;
			}
			beatenValues += index;
		}
		double averageBeatenValues = beatenValues / INCREMENT_COUNT;
		double percentage = averageBeatenValues / INCREMENT_COUNT;
		return percentage;
	}
}
