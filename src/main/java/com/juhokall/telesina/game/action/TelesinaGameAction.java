/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 * The general interface for the game actions.
 * @author juho
 */
@ImplementedBy(TelesinaGameActionSolver.class)
public interface TelesinaGameAction {
	
	/**
	 *	Method that triest alter a situation with a given solution.
	 * @param situation The situation to be solved and changed.
	 * @param solution The solution to be used.
	 * @return true if the solution is valid, false if not.
	 */
	public Boolean solve(Situation situation, Solution solution);
}
