/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerImpl implements TelesinaRangeAnalyzer{

	@Override
	public HandRange[] getRanges(Situation situation) {
			Player player = situation.getActivePlayer();
		player.getHand();
		
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
