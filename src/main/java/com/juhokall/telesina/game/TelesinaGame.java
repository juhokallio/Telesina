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
 *
 * @author juho
 */
@ImplementedBy(TelesinaGameImpl.class)
public interface TelesinaGame {

	public void dealCardForPlayer(int card, int playerNumber);
	public Situation solveSituation(Situation situation, Solution solution);
	public Situation getSituation();
	public void setNewGame(int numberOfPlayers);
	public void setNewGame(Situation situation);
	public Set getDeck();
}
