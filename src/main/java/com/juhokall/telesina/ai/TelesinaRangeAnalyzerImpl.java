/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;
import java.util.Map;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerImpl implements TelesinaRangeAnalyzer{

	@Override
	public HandRange[] getRanges(Situation situation) {
			Map players = situation.getPlayers();
		
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
