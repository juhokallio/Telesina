/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.rules.TelesinaHandRater;

/**
 *
 * @author juho
 */
public class TelesinaPostflopAIImpl implements TelesinaPostflopAI{

	private TelesinaRangeAnalyzer rangeAnalyzer;
	private HandSimulator handSimulator;
	private TelesinaHandRater handRater;

	@Inject
	public TelesinaPostflopAIImpl(TelesinaRangeAnalyzer rangeAnalyzer, HandSimulator handSimulator, TelesinaHandRater handRater) {
		this.rangeAnalyzer = rangeAnalyzer;
		this.handSimulator = handSimulator;
		this.handRater = handRater;
	}
	
	@Override
	public Solution getSolution(Situation situation) {
		HandRange[] ranges = rangeAnalyzer.getRanges(situation);
		

		return null;
	}
	
}
