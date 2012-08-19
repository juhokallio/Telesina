/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juho
 */
public class HandRange {
private final static int ORIGINAL_WEIGHT = 100;	
	private ArrayList<TelesinaValuedCard> handValues;
	private ArrayList<Integer> values;
		private int[] range;
		private TelesinaValuedCardComparator comparator;
	
	public HandRange() {
		range = new int[Telesina.DECK_LENGTH];
		for(int i = 0; i < Telesina.DECK_LENGTH; i++) {
			range[i] = ORIGINAL_WEIGHT;
		} 
		handValues = new ArrayList<TelesinaValuedCard>();
		values = new ArrayList<Integer>();
		comparator = new TelesinaValuedCardComparator();
	}

	public void sortValues() {
		Collections.sort(handValues, comparator);
		Collections.sort(values);
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
		values.add(valuedCard.getValue());
		handValues.add(valuedCard);
	}
	public ArrayList<Integer> getValues() {
		return values;
	}
}
