/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;

/**
 *The util class especially for the strategy crawler. 
 * @author juho
 */
@ImplementedBy(StrategyFactorySimple.class)
public interface StrategyFactory {
	/**
 * Creates a set of candidate strategies. Default function is non-lazy.
 * @author juho
 */
	public Set<Strategy> getStrategies(Situation situation);
	/**
 *Creates a set of candidate strategies. Lets to choose the lighter lazy mode.
 * @author juho
 */
	public Set<Strategy> getStrategies(Situation situation, Boolean lazyStrategy);
}
