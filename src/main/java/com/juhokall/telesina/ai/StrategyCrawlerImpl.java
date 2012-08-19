/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.ai.Strategy;
import com.juhokall.telesina.model.ai.Tactic;
import com.juhokall.telesina.model.core.Telesina;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author juho
 */
public class StrategyCrawlerImpl implements StrategyCrawler {

	private StrategyFactory strategyFactory;
	private TelesinaGame game;
	private RangeComparator rangeComparator;

	@Inject
	public StrategyCrawlerImpl(StrategyFactory strategyFactory, TelesinaGame game, RangeComparator rangeComparator) {
		this.strategyFactory = strategyFactory;
		this.game = game;
		this.rangeComparator = rangeComparator;
	}

	@Override
	public int crawlStrategy(Situation situation, Strategy strategy) {
		if(situation.getStreet() == Telesina.STREET_COUNT - 1 && situation.getPlayersLeft() == 0) {
			double equity = rangeComparator.getEquity(situation.getActivePlayer().getRange(), situation.getNonActivePlayers()[0].getRange());
			
		}
		int value = 0;
		Map<Integer, Tactic> tactics = strategy.getTactics();
		Tactic tactic;
		for (int rangeLimit : tactics.keySet()) {
			tactic = tactics.get(rangeLimit);
			int[] actionPercentages = tactic.getActionPercentages();
			for (int actionIndex = 0; actionIndex < Telesina.ACTION_TYPE_COUNT; actionIndex++) {
				if (actionPercentages[actionIndex] > 0) {
					int probability = rangeLimit * actionPercentages[actionIndex];
					if (Telesina.SOLUTION_TYPES[actionIndex] == SolutionType.FOLD) {
						value -= probability * situation.getPotSize();
					} else if(situation.getStreet() == Telesina.STREET_COUNT && situation.) {
						value += probability * situation.getPotSize();//asdfg
					}else{
						Solution solution = new Solution(Telesina.SOLUTION_TYPES[actionIndex]);
						Situation nextSituation = game.solveSituation(solution);
						Set<Strategy> nextStrategies = strategyFactory.getStrategies(nextSituation, true);
						int nextStrategyValue = crawlStrategySet(nextSituation, nextStrategies).getEstimatedValue();
						value -= rangeLimit * actionPercentages[actionIndex] * nextStrategyValue;
					}
				}
			}
		}
		strategy.setEstimatedValue(value);
		return value;
	}

	public Strategy crawlStrategySet(Situation situation, Set<Strategy> strategies) {
		Strategy bestStrategy = null;
		for (Strategy strategy : strategies) {
			crawlStrategy(situation, strategy);
			if (bestStrategy == null || strategy.getEstimatedValue() > bestStrategy.getEstimatedValue()) {
				bestStrategy = strategy;
			}
		}
		return bestStrategy;
	}
}
