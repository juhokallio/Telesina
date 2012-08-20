/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.core.Telesina;

/**
 *
 * @author juho
 */
public class Call implements TelesinaGameAction {

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		int betSize = solution.getSolutionSize();
		Player hero = situation.getActivePlayer();
		int takenFromStack = hero.removeFromStack(betSize);
		situation.addToPot(takenFromStack);
		if (hero.getStack() == 0 && situation.getPlayerCount() <= 2) {
			situation.setStreet(Telesina.STREET_COUNT - 1);
		}
		situation.decreasePlayersLeft();
		return true;
	}
}
