/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.HandRange;

/**
 *
 * @author juho
 */
@ImplementedBy(RangeComparatorImpl.class)
public interface RangeComparator {
	
	public double getEquity(HandRange range1, HandRange range2);
}
