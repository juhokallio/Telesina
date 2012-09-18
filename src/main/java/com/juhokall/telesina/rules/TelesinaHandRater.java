/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.TelesinaHand;

/**
 * Telesina hand rater. Rates the hands.
 * @author juho
 */
@ImplementedBy(TelesinaHandRaterImpl.class)
public interface TelesinaHandRater {
	
	/**
	 * Gives a cards value alone without the rest of the hand.
	 * @param card Integer representation of card.
	 * @return Integer representation of the value.
	 */
	public int getHighcardValue(int card);
	/**
	 * Gives the value of a Telesina hand.
	 * @param hand Telesina hand
	 * @return Integer representation of the value. 
	 */
	public int getTelesinaHandValue(TelesinaHand hand);
	/**
	 * Gives the value of a Telesina hand.
	 * @param hand Array of the integer representations of the cards.
	 * @return Integer representation of the value.
	 */
	public int getTelesinaHandValue(int[] hand);
}
