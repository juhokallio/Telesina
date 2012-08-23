/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;

/**
 * The heavy duty class. Solves the game theoretic problems. Highly recursive methods that launch each other.
 * @author juho
 */
@ImplementedBy(StrategyCrawlerImpl.class)
public interface StrategyCrawler {
	/**
 * Crawls through a strategy in specific situation and sets an estimated value to it,
 * @author juho
 */
	public void crawlStrategy(Situation situation, Strategy strategy);
		/**
 * Crawls through a set of strategies in specific situation and returns the best one.
 * @author juho
 */
	public Strategy crawlStrategySet(Situation situation, Set<Strategy> strategies);
			/**
 * Gives a numeric estimation of a tactic in a given situation.
 * @author juho
 */
	public int valueTactic(Situation situation, SolutionType tacticType);
}
