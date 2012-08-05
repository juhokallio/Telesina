/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.ImplementedBy;

/**
 *
 * @author juho
 */
@ImplementedBy(TelesinaRulesImpl.class)
public interface TelesinaRules {
	/**
	* Result breakdown
	*  1: hand2 wins
	*  0: hand1 wins
	* -1: hands are equal
	* -2: hands are not valid
	*/ 
	
/**
 * Number n (0-31) represents a card.
 * 
 * n / 8 gives the suit:
 *  3: Hearts
 *  2: Diamonds
 *  1: Clubs
 *  0: Spades
 * 
 * n % 8 gives the rank:
 *  0: seven
 *  1: eight
 *  2: nine
 *  3: ten
 *  4: Jack
 *  5: Queen
 *  6: King
 *  7: Ace
 */	
    public int getWinner(int[][] hands);
    //public String getWinner(String[] hand1, String[] hand2);
}
