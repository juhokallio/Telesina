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
    public void crawlStrategy(Situation situation, Strategy strategy) {
        int value = 0;
        Map<Integer, Tactic> tactics = strategy.getTactics();
        Tactic tactic;
        for (int rangeLimit : tactics.keySet()) {
            double rl = (double) rangeLimit;
            tactic = tactics.get(rangeLimit);
            int[] actionPercentages = tactic.getActionPercentages();
            for (int actionIndex = 0; actionIndex < Telesina.ACTION_TYPE_COUNT; actionIndex++) {
                if (actionPercentages[actionIndex] > 0) {
                    double probability = (rl / 100) * (((double) actionPercentages[actionIndex]) / 100);
                    value += valueTactic(situation, probability, Telesina.SOLUTION_TYPES[actionIndex]);
                }
            }
        }
        strategy.setEstimatedValue(value);
    }

    @Override
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

    @Override
    public int valueTactic(Situation situation, double probability, SolutionType tacticType) {
        int value = 0;
        if (tacticType == SolutionType.FOLD) {
            value -= probability * situation.getPotSize();
        } else {
            Solution solution = new Solution(tacticType, situation);
            Situation nextSituation = game.solveSituation(situation, solution);
            if (situationHasPlayLeft(nextSituation)) {
                Set<Strategy> nextStrategies = strategyFactory.getStrategies(nextSituation, true);
                Strategy bestStrategy = crawlStrategySet(nextSituation, nextStrategies);
                int nextStrategyValue = 0;
                if(bestStrategy != null) {
                    nextStrategyValue = bestStrategy.getEstimatedValue();
                }
                value -= probability * nextStrategyValue + solution.getSolutionSize();
            } else {
                value += (valueRanges(situation) - solution.getSolutionSize()) * probability;
            }
        }
        return value;
    }

    private boolean situationHasPlayLeft(Situation s) {
        boolean playLeft = true;
        Map<Integer, Player> players = s.getPlayers();
        if (s.getStreet() >= Telesina.STREET_COUNT) {
            playLeft = false;
        }
        for (Player p : players.values()) {
            if (p.getStack() <= 0) {
                playLeft = false;
            }
        }

        return playLeft;
    }

    private int valueRanges(Situation s, int probability) {
        return valueRanges(s) * probability;
    }

    private int valueRanges(Situation s) {
        Player hero = s.getActivePlayer(), villain = s.getNonActivePlayers()[0];
        double rangeEquity = rangeComparator.getEquity(hero.getRange(), villain.getRange());
        return (int) (rangeEquity * s.getPotSize());
    }
}
