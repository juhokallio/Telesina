/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.juhokall.telesina.model.Telesina;

/**
 *
 * @author juho
 */
public class TextualHumanizer implements TelesinaHumanizer{

	@Override
	public String humanizeCard(int card) {
		String returned;
		if(card >= 0 && card < Telesina.DECK_LENGTH) {
			int suit = card / Telesina.RANK_COUNT;
			int rank = card % Telesina.RANK_COUNT;
			returned = Telesina.RANKS_SHORT[rank] + Telesina.SUITS_SHORT[suit];
		} else {
			returned = "NN";
		}

		return returned;
	}

	@Override
	public int dehumanizeCard(String card) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	
}
