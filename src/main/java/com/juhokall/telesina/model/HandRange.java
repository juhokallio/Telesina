/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 *
 * @author juho
 */
public class HandRange {
private final static int ORIGINAL_WEIGHT = 100;	
	private int[] range;

	public HandRange() {
		range = new int[Telesina.DECK_LENGTH];
		for(int i = 0; i < Telesina.DECK_LENGTH; i++) {
			range[i] = ORIGINAL_WEIGHT;
		} 
	}

	public int[] getRange() {
		return range;
	}

	public void setRange(int[] range) {
		this.range = range;
	}
	
	public void removeFromRange (int card) {
		range[card] = 0;
	}
}
