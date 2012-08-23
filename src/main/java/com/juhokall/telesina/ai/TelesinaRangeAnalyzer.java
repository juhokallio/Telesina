/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;

/**
 * Range creation for the players. 
 * @author juho
 */
@ImplementedBy(TelesinaRangeAnalyzerImpl.class)
public interface TelesinaRangeAnalyzer {
	/**
 * Estimates ranges for all the players, given the situation, their cards and their former ranges.
 * @author juho
 */
	public HandRange[] getRanges(Situation situation);
}
