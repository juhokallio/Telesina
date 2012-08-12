/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 *
 * @author juho
 */
public class TelesinaValuedCard {
	
	int value;
	int card;

	public TelesinaValuedCard(int card, int value) {
		this.value = value;
		this.card = card;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}
	
}
