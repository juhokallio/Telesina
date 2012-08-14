/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juho
 */
public class Strategy {

	private Map<Integer, Tactic> tactics;
	int estimatedValue;

	public Strategy(Map<Integer, Tactic> tactics) {
		this.tactics = tactics;
	}

	public Strategy() {
		tactics = new HashMap<Integer, Tactic>();
	}

	public Tactic getTactic(int telesinaHandRating) {
		int closestBreakpoint = -1;
		for (int breakpoint : tactics.keySet()) {
			if (telesinaHandRating > breakpoint && (closestBreakpoint == -1 || breakpoint < closestBreakpoint)) {
				closestBreakpoint = telesinaHandRating;
			}
		}
		if (closestBreakpoint != -1) {
			return tactics.get(closestBreakpoint);
		} else {
			System.out.println("The strategy was empty and returned an empty tactic.");
			return new Tactic();
		}
	}

	public void putNewTactic(int breakpoint, Tactic tactic) {
		tactics.put(breakpoint, tactic);
	}

	public int getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
}
