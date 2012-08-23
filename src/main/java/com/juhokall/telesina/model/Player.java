/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;

/**
 *
 * @author juho
 */
public class Player {

	private int stack;
	private HandRange range;
	private TelesinaHand hand;
	private Solution lastSolution;

	public Player(int stack) {
		lastSolution = new Solution(SolutionType.CHECK);
		range = new HandRange();
		hand = new TelesinaHand();
		this.stack = stack;
	}

	public Player() {
		this(Telesina.DEFAULT_STACK);
	}

	@Override
	public Player clone() {
		Player p = new Player(stack);
		p.setHand(hand);
		p.setLastSolution(lastSolution);
		p.setRange(range);
		return p;
	}

	public int removeFromStack(int amount) {
		int toBeTaken;
		if (stack >= amount) {
			toBeTaken = amount;
		} else {
			toBeTaken = stack;
		}
		stack -= toBeTaken;
		return toBeTaken;
	}

	public void addToStack(int amount) {
		stack += amount;
	}

	public Solution getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(Solution lastSolution) {
		this.lastSolution = lastSolution;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public HandRange getRange() {
		return range;
	}

	public void setRange(HandRange range) {
		this.range = range;
	}

	public TelesinaHand getHand() {
		return hand;
	}

	public void setHand(TelesinaHand hand) {
		this.hand = hand;
	}
}
