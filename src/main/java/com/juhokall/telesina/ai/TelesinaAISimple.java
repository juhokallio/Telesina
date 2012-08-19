/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;

/**
 *
 * @author juho
 */
public class TelesinaAISimple implements TelesinaAI{
	private StrategyFactory strategyFactory;
	
	@Override
	public Solution getSolution(Situation situation) {
		Solution solution;
		
		Set<Strategy> strategies = strategyFactory.getStrategies(situation, true);	
		

		return solution;
	}
	

	
}
