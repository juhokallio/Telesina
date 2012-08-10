/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;

/**
 *
 * @author juho
 */
public interface TelesinaRangeAnalyzer {
	public HandRange[] getRanges(Situation situation);
}
