/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
public void removeFromStack(int amount) {
	
	stack -= amount;
}
public void addToStack (int amount){
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

	public Player() {
		hand = new TelesinaHand(); 
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
