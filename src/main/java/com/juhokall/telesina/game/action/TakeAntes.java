/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import java.util.Map;

/**
 * Solves the TakeAntes action.
 * @author juho
 */
public class TakeAntes implements TelesinaGameAction{

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		Map<Integer, Player> players = situation.getPlayers();
		for(Player player : players.values()) {
			player.removeFromStack(solution.getSolutionSize());
			situation.addToPot(solution.getSolutionSize());
		}
		return true;
	}
	
}
