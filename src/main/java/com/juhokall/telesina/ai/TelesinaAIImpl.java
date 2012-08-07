/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
public class TelesinaAIImpl implements TelesinaAI {

	@Inject
	TelesinaPreflopAI preflopAI;
	@Inject
	TelesinaPostflopAI postflopAI;

	@Override
	public Solution getSolution(Situation situation) {
		Solution solution = null;
		if (situation.getStreet() == 0) {
			solution = preflopAI.getSolution(situation);
		} else {
			solution = postflopAI.getSolution(situation);	
		}
		return solution;
	}
}
