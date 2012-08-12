/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juho
 */
public class HandRange {
private final static int ORIGINAL_WEIGHT = 100;	
	private ArrayList<TelesinaValuedCard> handValues;
		private int[] range;
		private TelesinaValuedCardComparator comparator;
	
	public HandRange() {
		range = new int[Telesina.DECK_LENGTH];
		for(int i = 0; i < Telesina.DECK_LENGTH; i++) {
			range[i] = ORIGINAL_WEIGHT;
		} 
		handValues = new ArrayList<TelesinaValuedCard>();
		comparator = new TelesinaValuedCardComparator();
	}

	public void sortValues() {
		Collections.sort(handValues, comparator);
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

	public ArrayList<TelesinaValuedCard> getHandValues() {
		return handValues;
	}
	
	public void addValuedCard (TelesinaValuedCard valuedCard){
		handValues.add(valuedCard);
	}
}
