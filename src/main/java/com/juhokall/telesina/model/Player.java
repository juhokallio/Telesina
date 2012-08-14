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

	private Long id;
	private int stack;
	private HandRange range;
	private TelesinaHand hand;
	private Solution lastSolution;
	private Boolean turnLeft;
	private int number;
	private PlayerType playerType;
	private int handRankedFor;

	public Player(int stack) {
		id = 0l;
		playerType = PlayerType.VILLAIN;
		number = 0;
		range = new HandRange();
		hand = new TelesinaHand();
		this.stack = stack;
	}

	public Player() {
		this(Telesina.DEFAULT_STACK);
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public Solution getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(Solution lastSolution) {
		this.lastSolution = lastSolution;
	}

	public Boolean getTurnLeft() {
		return turnLeft;
	}

	public void setTurnLeft(Boolean turnLeft) {
		this.turnLeft = turnLeft;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
