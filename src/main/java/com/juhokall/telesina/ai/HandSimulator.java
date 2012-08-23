/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.TelesinaHand;

/**
 *Situation hand value simulator.
 * @author juho
 */
@ImplementedBy(HandSimulatorImpl.class)
public interface HandSimulator{
	/**
 *Marks a card that is not in the play.
 * @author juho
 */
	public void addPlayedCard(int card);
		/**
 *Marks multible cards (hand) that are not in the play.
 * @author juho
 */
	public void addPlayedHand(TelesinaHand hand);
			/**
 *Simulates a hand once.
 * @author juho
 */
	public int getValue(TelesinaHand hand);
			/**
 *Simulates a hand once. Lets to choose the next card that will come. This is also helpful, when simulating a hand with known hole card.
 * @author juho
 */
	public int getValue(TelesinaHand hand, int nextCard);
}
