/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author juho
 */
public class RangeComparatorImpl implements RangeComparator {

	@Override
	public double getEquity(HandRange range1, HandRange range2) {
		List<Integer> values2 = range2.getValues();
		List<Integer> values1 = range1.getValues();
		double beatenValues = new Double(0);
		int index = 0;
		for (int value : values1) {
			while (index < values2.size() && value > values2.get(index)) {
				index++;
			}
			beatenValues += index;
		}
		double averageBeatenValues = beatenValues / values1.size();
		double percentage = averageBeatenValues / values2.size();
		return percentage;
	}
}
