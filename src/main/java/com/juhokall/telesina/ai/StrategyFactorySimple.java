/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.Strategy;
import com.juhokall.telesina.model.ai.Tactic;

/**
 *
 * @author juho
 */
public class StrategyFactorySimple implements StrategyFactory{
	private static final int[] breakpoints = {25, 50, 75, 100};

	@Override
	public Strategy[] getStrategies(Situation situation) {
		Strategy[] strategies = new Strategy[4];
	
	
		//fill strategies with default tactics
			
		return strategies;
	}
	
}

