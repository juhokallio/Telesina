/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;

/**
 *
 * @author juho
 */
public class TelesinaPostflopAIImpl implements TelesinaPostflopAI{

	private StrategyFactory strategyFactory;
	private TelesinaRangeAnalyzer rangeAnalyzer;
	
	@Inject
	public TelesinaPostflopAIImpl(StrategyFactory strategyFactory, TelesinaRangeAnalyzer rangeAnalyzer) {
		this.strategyFactory = strategyFactory;
		this.rangeAnalyzer = rangeAnalyzer;
	}
	
	@Override
	public Solution getSolution(Situation situation) {
		Set<Strategy> strategyCandidates = strategyFactory.getStrategies(situation);
		HandRange[] ranges = rangeAnalyzer.getRanges(situation);
		
		return null;
	}
	
}
