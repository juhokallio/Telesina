/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.HandRange;

/**
 * An util class to help comparing HandRange values.
 * @author juho
 */
@ImplementedBy(RangeComparatorImpl.class)
public interface RangeComparator {
	/**
 * Returns the equity that the range1 has against range2. If range1 loses always, the equity is zero. If it always wins, equity is one. With equal chances the equity is 0,5.
 * @author juho
 */
	public double getEquity(HandRange range1, HandRange range2);
}
