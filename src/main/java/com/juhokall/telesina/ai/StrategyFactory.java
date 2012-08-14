/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;

/**
 *
 * @author juho
 */
public interface StrategyFactory {
	public Strategy[] getStrategies(Situation situation);
	
}
