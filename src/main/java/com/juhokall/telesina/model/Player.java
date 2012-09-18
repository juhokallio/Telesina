/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;

/**
 * Class that models the player.
 * @author juho
 */
public class Player {

	private int stack;
	private HandRange range;
	private TelesinaHand hand;

	/**
	 *	Constructor
	 * @param stack The initial stack size.
	 */
	public Player(int stack) {
		range = new HandRange();
		hand = new TelesinaHand();
		this.stack = stack;
	}

	/**
	 *	Constructor
	 */
	public Player() {
		this(Telesina.DEFAULT_STACK);
	}

	/**
	 *	Clone method.
	 * @return clone
	 */
	@Override
	public Player clone() {
		Player p = new Player(stack);
		p.setHand(hand);
		p.setRange(range.clone());
		return p;
	}

	/**
	 *	Removes chips from the stack.
	 * @param amount Amount to be removed.
	 * @return The amount that was taken.
	 */
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

	/**
	 *	Adds chips to the stack
	 * @param amount Amount to be added.
	 */
	public void addToStack(int amount) {
		stack += amount;
	}

	/**
	 * Gives the stack size.
	 * @return The stack size.
	 */
	public int getStack() {
		return stack;
	}

	/**
	 * Sets the stack size.
	 * @param stack The stack size.
	 */
	public void setStack(int stack) {
		this.stack = stack;
	}

	/**
	 * Gives the range.
	 * @return The range.
	 */
	public HandRange getRange() {
		return range;
	}

	/**
	 *	Sets the range
	 * @param range Player's range.
	 */
	public void setRange(HandRange range) {
		this.range = range;
	}

	/**
	 *	Gets the player's hand.
	 * @return TelesinaHand form of the hand.
	 */
	public TelesinaHand getHand() {
		return hand;
	}

	/**
	 * Sets the player's hand
	 * @param hand TelesinaHand form of the hand.
	 */
	public void setHand(TelesinaHand hand) {
		this.hand = hand;
	}
}
