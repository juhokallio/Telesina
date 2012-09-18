/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models a strategy. Strategy is an important building block in 
 * this implementation of poker AI. It represent a way to handle certain
 * situation.
 * @author juho
 */
public class Strategy {

	private ArrayList<Tactic> tactics;
	private int estimatedValue;

	/**
	 * Constructor
	 * @param tactics Tactics to give for this strategy.
	 */
	public Strategy(ArrayList<Tactic> tactics) {
		this.tactics = tactics; 
	}
	
	/**
	 * Constructor that copies an existing strategy
	 * @param strategy Strategy that will be copied
	 */
	public Strategy(Strategy strategy) {
		if (strategy != null) {
			tactics = new ArrayList<Tactic> ();
			List<Tactic> sourceTactics = strategy.getTactics();
			for (Tactic tactic : sourceTactics) {
				tactics.add(tactic.clone());
			}
		}
	}

	/**
	 * Constructor
	 */
	public Strategy() {
		tactics = new ArrayList<Tactic> ();
	}

	/**
	 * Gives the tactic that fits the given percentage.
	 * @param zeroToHundred A percentage point from the strategy. 0-100.
	 * @return Tactic that fits the percentage point.
	 */
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
			return tactics.get(closestBreakpoint);
		} else {
			System.out.println("The strategy was empty and returned an empty tactic.");
			return new Tactic();
		}
	}

	/**
	 * Gets all the tactics the strategy has.
	 * @return The strategy's tactis.
	 */
	public List<Tactic> getTactics() {
		return tactics;
	}

	/**
	 * Puts a tactic to the strategy.
	 * @param tactic Tactic to be put.
	 */
	public void putNewTactic(Tactic tactic) {
		List<Tactic> o = getTactics();
	
		tactics.add(tactic);
		int i=0;
	}

	/**
	 *	Gets the estimated value of this strategy.
	 * @return Integer representation of the estimated value.
	 */
	public int getEstimatedValue() {
		return estimatedValue;
	}

	/**
	 *	Sets the estimated value of this strategy.
	 * @param estimatedValue Integer representation of the estimated value.
	 */
	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
}
