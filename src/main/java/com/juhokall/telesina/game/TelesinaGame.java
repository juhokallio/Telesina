/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
public interface TelesinaGame {

	public void dealNewCards();
	public void dealCardForPlayer(int card, int playerNumber);
	public Situation solveSituation(Solution solution);
	public Situation getSituation();
}
