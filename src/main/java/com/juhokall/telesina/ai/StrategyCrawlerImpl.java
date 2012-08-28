/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Strategy;
import com.juhokall.telesina.model.ai.Tactic;
import com.juhokall.telesina.model.core.Telesina;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author juho
 */
public class StrategyCrawlerImpl implements StrategyCrawler {

	private final static int MAX_DEPTH = 2;
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
	public void crawlStrategy(Situation situation, Strategy strategy) {
		crawlStrategy(situation, strategy, 0);
	}

	@Override
	public Strategy crawlStrategySet(Situation situation, Set<Strategy> strategies) {
		return crawlStrategySet(situation, strategies, 0);
	}

	@Override
	public int valueTactic(Situation situation, SolutionType tacticType) {
		return valueTactic(situation, tacticType, 0, 0, 100);
	}

	public void crawlStrategy(Situation situation, Strategy strategy, int depth) {
		int value = 0, rangeLimit, rangeBottom;
		double actionPercentage, probability;
		List<Tactic> tactics = strategy.getTactics();
		Tactic tactic;
		for (int rangeSection = 0; rangeSection < AISettings.STRATEGY_CANDIDATE_COUNT; rangeSection++) {
			rangeLimit = AISettings.DEFAULT_BREAKPOINTS[rangeSection];
			tactic = tactics.get(rangeSection);
			for (int actionIndex = 0; actionIndex < Telesina.ACTION_TYPE_COUNT; actionIndex++) {
				actionPercentage = (double) tactic.getActionPercentages()[actionIndex];
				if (actionPercentage > 0) {
					probability = rangeLimit * actionPercentage / 100;
					rangeBottom = rangeLimit - 25;
					if (rangeBottom < 0) {
						rangeBottom = 0;
					}
					value += probability * valueTactic(situation, Telesina.SOLUTION_TYPES[actionIndex], depth, rangeBottom, rangeLimit);
				}
			}
		}
		strategy.setEstimatedValue(value);
	}

	public Strategy crawlStrategySet(Situation situation, Set<Strategy> strategies, int depth) {
		Strategy bestStrategy = null;
		for (Strategy strategy : strategies) {
			crawlStrategy(situation, strategy, depth);
			if (bestStrategy == null || strategy.getEstimatedValue() > bestStrategy.getEstimatedValue()) {
				bestStrategy = strategy;
			}
		}
		return bestStrategy;
	}

	public int valueTactic(Situation situation, SolutionType tacticType, int depth, int rangeBottom, int rangeTop) {
		int value = 0;
		if (tacticType == SolutionType.FOLD) {
			value -= situation.getPotSize();
		} else {
			Solution solution = new Solution(tacticType, situation);
			Situation nextSituation = game.solveSituation(situation, solution);
			nextSituation.setActivePlayersRanges(rangeBottom, rangeTop);
			if (situationHasPlayLeft(nextSituation) && depth < MAX_DEPTH) {
				Set<Strategy> nextStrategies = strategyFactory.getStrategies(nextSituation, true);
				Strategy bestStrategy = crawlStrategySet(nextSituation, nextStrategies, depth + 1);
				int nextStrategyValue = 0;
				if (bestStrategy != null) {
					nextStrategyValue = bestStrategy.getEstimatedValue();
				}
				value -= nextStrategyValue + solution.getSolutionSize();
			} else {
				value += valueRanges(situation) - solution.getSolutionSize();
			}
		}
		return value;
	}

	private boolean situationHasPlayLeft(Situation situation) {
		boolean playLeft = true;
		Map<Integer, Player> players = situation.getPlayers();
		if (situation.getStreet() >= Telesina.STREET_COUNT) {
			playLeft = false;
		}
		for (Player p : players.values()) {
			if (p.getStack() <= 0) {
				playLeft = false;
			}
		}
		return playLeft;
	}

	private int valueRanges(Situation situation, int probability) {
		return valueRanges(situation) * probability;
	}

	private int valueRanges(Situation s) {
		Player hero = s.getActivePlayer(), villain = s.getNonActivePlayers()[0];
		double rangeEquity = rangeComparator.getEquity(hero.getRange(), villain.getRange());
		return (int) (rangeEquity * s.getPotSize());
	}
}
