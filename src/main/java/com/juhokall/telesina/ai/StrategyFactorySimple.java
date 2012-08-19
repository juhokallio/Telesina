/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Strategy;
import com.juhokall.telesina.model.ai.Tactic;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author juho
 */
public class StrategyFactorySimple implements StrategyFactory {

	@Override
	public Set<Strategy> getStrategies(Situation situation, Boolean lazyStrategy) {
		Solution lastSolution = situation.getLastSolution();
		SolutionType lastSolutionType = lastSolution.getSolutionType();
		return getStrategies(lastSolutionType, lazyStrategy);
	}

	@Override
	public Set<Strategy> getStrategies(Situation situation) {
		return getStrategies(situation, false);
	}

	private Set<Strategy> getStrategies(SolutionType lastSolutionType, Boolean lazyStrategy) {
		if (lazyStrategy) {
			if (lastSolutionType == SolutionType.CHECK) {
				return buildStrategies(new Strategy(), 0, AISettings.LAZY_BREAKPOINTS, AISettings.LAZY_1ST_ACTION_PERCENTAGES);
			} else {
				return buildStrategies(new Strategy(), 0, AISettings.LAZY_BREAKPOINTS, AISettings.LAZY_2ST_ACTION_PERCENTAGES);
			}
		} else {
			if (lastSolutionType == SolutionType.CHECK) {
				return buildStrategies(new Strategy(), 0, AISettings.DEFAULT_BREAKPOINTS, AISettings.DEFAULT_1ST_ACTION_PERCENTAGES);
			} else {
				return buildStrategies(new Strategy(), 0, AISettings.DEFAULT_BREAKPOINTS, AISettings.DEFAULT_2ST_ACTION_PERCENTAGES);
			}
		}
	}

	private Set<Strategy> buildStrategies(Strategy strategy, int breakpointNumber, int[] breakpoints, int[][] actionPercentages) {
		Set<Strategy> strategies = new HashSet<Strategy>();
		for (int[] actionPercentageSet : actionPercentages) {
			Strategy s = new Strategy(strategy);
			s.putNewTactic(AISettings.DEFAULT_BREAKPOINTS[breakpointNumber], new Tactic(actionPercentageSet));
			if (breakpointNumber < AISettings.DEFAULT_BREAKPOINTS.length - 1) {
				strategies.addAll(buildStrategies(s, breakpointNumber + 1, breakpoints, actionPercentages));
			}
		}
		return strategies;
	}
}
