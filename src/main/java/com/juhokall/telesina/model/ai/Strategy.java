/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juho
 */
public class Strategy {

	//private Map<Integer, Tactic> tactics;
	private ArrayList<Tactic> tacticss;
	private int estimatedValue;

//	public Strategy(Map<Integer, Tactic> tactics) {
//		this.tactics = tactics;
//	}
	
	public Strategy(ArrayList<Tactic> tacticss) {
		this.tacticss = tacticss; 
	}
	
	public Strategy(Strategy strategy) {
		if (strategy != null) {
			tacticss = new ArrayList<Tactic> ();
			List<Tactic> sourceTactics = strategy.getTactics();
			for (Tactic tactic : sourceTactics) {
				tacticss.add(tactic.clone());
			}
		}
	}

	public Strategy() {
		tacticss = new ArrayList<Tactic> ();
	}

	public Tactic getTactic(int zeroToHundred) {
		int closestBreakpoint = -1;
		int breakpoint;
		for (int i = 0; i < AISettings.STRATEGY_CANDIDATE_COUNT; i++){ 
			breakpoint = AISettings.DEFAULT_BREAKPOINTS[i]; 
			if (zeroToHundred > breakpoint && (closestBreakpoint == -1 || breakpoint < closestBreakpoint)) {
				closestBreakpoint = i;
			}
		}
		if (closestBreakpoint != -1) {
			return tacticss.get(closestBreakpoint);
		} else {
			System.out.println("The strategy was empty and returned an empty tactic.");
			return new Tactic();
		}
	}

	public List<Tactic> getTactics() {
		return tacticss;
	}

	public void putNewTactic(Tactic tactic) {
		List<Tactic> o = getTactics();
	
		tacticss.add(tactic);
		int i=0;
	}
//	public void putNewTactic(int breakpoint, Tactic tactic) {
//		int[] actionPercentages = {20,20,20,20,20};	
//		this.tactics.put(breakpoint, new Tactic(actionPercentages));
//		Map ts = tactics;
//		int i = 0;
//	}

	public int getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
}
