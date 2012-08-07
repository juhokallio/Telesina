/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
public class Call implements TelesinaGameAction {

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		int betSize = solution.getSolutionSize();
		int takenFromStack = situation.getActivePlayer().removeFromStack(betSize);
		situation.addToPot(takenFromStack);
		return true;
	}
	
}