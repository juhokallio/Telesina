/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.TelesinaHand;

/**
 * Class that helps to create playable Telesina applications.
 * @author juho
 */
@ImplementedBy(PlayableTelesinaGameImpl.class)
public interface PlayableTelesinaGame extends TelesinaGame {
 	/**
	 *	Deals the next street. Changes the situation by adding the next card and
	 * setting variables to the initial beginning of the street state.
	 * @param situation The situation that will get altered.
	 */
	public void dealNextStreet(Situation situation);	
	/**
	 * Deals the holecard for a player.
	 * @param playerNumber The player's id in this situation
	 * @return integer representation of the hole card
	 */
	public int dealHoleCard(int playerNumber);
	/**
	 *	Gets the cards of a player.
	 * @param playerNumber The player's id in this situation.
	 * @return Array of the integer representations of the player's cards.
	 */
	public int[] getPlayersCards(int playerNumber);
	/**
	 * Gets the hand of a player.
	 * @param playerNumber The player's id in this situation.
	 * @return TelesinaHand of the player.
	 */
	public TelesinaHand getPlayersHand(int playerNumber);
	/**
	 *	Gets the id of the active player.
	 * @return Id of the active player.
	 */
	public int getActivePlayer ();
}
