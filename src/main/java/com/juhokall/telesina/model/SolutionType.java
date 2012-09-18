/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 * The possible types of a solution
 * @author juho
 */
public enum SolutionType {

	/**
	 * Fold is a solution that gives up the hand.
	 */
	FOLD (4), 
	/**
	 * Call is a solution that continues by calling the former bet or raise.
	 */
	CALL (2), 
	/**
	 * Check just passes the turn to the next player.
	 */
	CHECK (3), 
	/**
	 * Bet places chips to the table.
	 */
	BET (1), 
	/**
	 * Raise places additional chips after a bet.
	 */
	RAISE (5),
	/**
	 * Antes are taken in the beginning of the hand.
	 */
	TAKE_ANTES (6);

	private int orderNumber;

	SolutionType(int orderNumber) {
		this.orderNumber = orderNumber;		
	}

	/**
	 * Gives the order number of a solution.
	 * @return The number of a solution.
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
}
