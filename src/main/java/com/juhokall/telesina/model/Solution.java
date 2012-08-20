/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 *
 * @author juho
 */
public class Solution {
	private HandRange range;	
	private SolutionType solutionType;
	private int solutionSize;


	public Solution(SolutionType solutionType, int solutionSize) {
		this.solutionType = solutionType;
		this.solutionSize = solutionSize;
	}

	public Solution(SolutionType solutionType) {
		this(solutionType, 0);
	}

	public Solution(SolutionType solutionType, Situation situation) {
		this.solutionType = solutionType;
		if(solutionType == SolutionType.CALL) {
			solutionSize = situation.getLastSolution().getSolutionSize();
		} else {
			solutionSize = situation.getPotSize();
		}
	}
	
	

	public HandRange getRange() {
		return range;
	}

	public void setRange(HandRange range) {
		this.range = range;
	}

	public SolutionType getSolutionType() {
		return solutionType;
	}

	public void setSolutionType(SolutionType solutionType) {
		this.solutionType = solutionType;
	}

	public int getSolutionSize() {
		return solutionSize;
	}

	public void setSolutionSize(int solutionSize) {
		this.solutionSize = solutionSize;
	}

	
}
