/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import java.util.Set;

/**
 * The core of game structure.
 * @author juho
 */
@ImplementedBy(TelesinaGameImpl.class)
public interface TelesinaGame {

		/**
 * Deals a card for the given player.
 * @param card 
 * @param playerNumber 
 * @author juho
 */
	public void dealCardForPlayer(int card, int playerNumber);
	
	/**
	 *	Creates a new situation out of an existing one and a solution.
	 * @param situation Situation
	 * @param solution Solution for the situation
	 * @return A new Situation object
	 */
	public Situation solveSituation(Situation situation, Solution solution);
	/**
	 * Returns the situation in the game.
	 * @return The situation in the game
	 */
	public Situation getSituation();
	/**
	 * Sets up a new game.
	 * @param numberOfPlayers The number of the players.
	 */
	public void setNewGame(int numberOfPlayers);
	/**
	 *	Sets up a new game
	 * @param situation The situation where the game starts in.
	 */
	public void setNewGame(Situation situation);
	/**
	 *	Gives the cards left in the deck in the given game.
	 * @return Set of cards left.
	 */
	public Set getDeck();
}
