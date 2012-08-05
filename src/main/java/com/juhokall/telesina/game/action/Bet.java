/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
public class Bet implements TelesinaGameAction {

	@Override
	public void solve(Situation situation, Solution solution) {
				int playerNumber = situation.getActivePlayersNumber();
		Player player = situation.getPlayers().get(playerNumber);
		int betSize = solution.getSolutionSize();
		player.removeFromStack(betSize);
		situation.addToPot(betSize);
	}
	
}
