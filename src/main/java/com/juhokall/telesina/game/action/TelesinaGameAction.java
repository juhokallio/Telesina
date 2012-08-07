/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
@ImplementedBy(TelesinaGameActionSolver.class)
public interface TelesinaGameAction {
	
	public Boolean solve(Situation situation, Solution solution);
}
