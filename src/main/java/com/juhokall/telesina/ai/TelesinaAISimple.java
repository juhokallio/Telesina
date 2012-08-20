/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Strategy;
import com.juhokall.telesina.model.ai.Tactic;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author juho
 */
public class TelesinaAISimple implements TelesinaAI {

	private StrategyFactory strategyFactory;
	private StrategyCrawler crawler;
	private HandSimulator handSimulator;
	private Random random;

	@Inject
	public TelesinaAISimple(StrategyFactory strategyFactory, StrategyCrawler crawler, HandSimulator handSimulator) {
		this.strategyFactory = strategyFactory;
		this.crawler = crawler;
		this.handSimulator = handSimulator;
		random = new Random();
	}

	@Override
	public Solution getSolution(Situation situation, int holeCard) {
		Set<Strategy> strategies = strategyFactory.getStrategies(situation, true);
		Strategy bestStrategy = crawler.crawlStrategySet(situation, strategies);
		Player hero = situation.getActivePlayer();
		int iterationValueSum = 0;
		for (int iteration = 0; iteration < AISettings.HAND_ITERATIONS; iteration++) {
			iterationValueSum += handSimulator.getValue(hero.getHand(), holeCard);
		}
		int handRating = iterationValueSum / AISettings.HAND_ITERATIONS;
		Tactic tactic = bestStrategy.getTactic(handRating);
		
		int rnd = random.nextInt(100);
		SolutionType solutionType = tactic.getAction(rnd);
		return new Solution(solutionType);
	}
}
