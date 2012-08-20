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
import com.juhokall.telesina.ai.StrategyCrawlerImpl;

/**
 *
 * @author juho
 */
@ImplementedBy(StrategyCrawlerImpl.class)
public interface StrategyCrawler {
	public void crawlStrategy(Situation situation, Strategy strategy);
	public Strategy crawlStrategySet(Situation situation, Set<Strategy> strategies);
	public int valueTactic(Situation situation, double probability, SolutionType tacticType);
}
