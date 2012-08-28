/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 *
 * @author juho
 */
public enum SolutionType {

	FOLD (4), 
	CALL (2), 
	CHECK (3), 
	BET (1), 
	RAISE (5),
	TAKE_ANTES (6);

	private int orderNumber;

	SolutionType(int orderNumber) {
		this.orderNumber = orderNumber;		
	}

	public int getOrderNumber() {
		return orderNumber;
	}
}
