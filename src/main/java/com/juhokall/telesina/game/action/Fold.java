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
public class Fold implements TelesinaGameAction {

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		situation.removeActivePlayer();
                situation.decreasePlayersLeft();
		return true;
	}
	
	
}
