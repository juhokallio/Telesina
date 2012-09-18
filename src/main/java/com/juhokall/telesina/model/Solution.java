/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 * Solution is the way how an action is described.
 * @author juho
 */
public class Solution {

	private SolutionType solutionType;
	private int solutionSize;

	/**
	 * Constructor
	 * @param solutionType The type of the solution.
	 * @param solutionSize The size of the solution.
	 */
	public Solution(SolutionType solutionType, int solutionSize) {
		this.solutionType = solutionType;
		this.solutionSize = solutionSize;
	}

	/**
	 * Constructor
	 * @param solutionType The type of the solution.
	 */
	public Solution(SolutionType solutionType) {
		this(solutionType, 0);
	}

	/**
	 * Constructor
	 * @param solutionType The type of the solution.
	 * @param situation The situation from which the solution comes.
	 */
	public Solution(SolutionType solutionType, Situation situation) {
		this.solutionType = solutionType;
		if (solutionType == SolutionType.CALL) {
			solutionSize = situation.getLastSolution().getSolutionSize();
		} else if (solutionType == SolutionType.RAISE) {
			int lastSolutionSize = situation.getLastSolution().getSolutionSize();
			int potAfterCall = situation.getPotSize() + lastSolutionSize;
			if (situation.getLastSolution().solutionType == SolutionType.BET) {
				solutionSize = potAfterCall;
			} else {
				solutionSize = potAfterCall + lastSolutionSize;
			}
		} else {
			solutionSize = situation.getPotSize();
		}
	}
	/**
	 * Gives the type of the solution.
	 * @return The type of the solution.
	 */
	public SolutionType getSolutionType() {
		return solutionType;
	}

	/**
	 *	Gives the size of the solution.
	 * @return The size of the solution.
	 */
	public int getSolutionSize() {
		return solutionSize;
	}

	/**
	 * Sets the size of the solution.
	 * @param solutionSize The size of the solution.
	 */
	public void setSolutionSize(int solutionSize) {
		this.solutionSize = solutionSize;
	}
}
