/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *Solves the Check action.
 * @author juho
 */
public class Check implements TelesinaGameAction{

	@Override
	public Boolean solve(Situation situation, Solution solution) {
                situation.decreasePlayersLeft();
		return true;
	}
	
}
