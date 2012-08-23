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
	private ArrayList<Integer> values;
	private int[] range;
	
	public HandRange() {
		range = new int[Telesina.DECK_LENGTH];
		for (int i = 0; i < Telesina.DECK_LENGTH; i++) {
			range[i] = ORIGINAL_WEIGHT;
		}		
		values = new ArrayList<Integer>();
	}
	
	public void sortValues() {
		Collections.sort(values);
	}
	
	public int[] getRange() {
		return range;
	}
	
	public void setRange(int[] range) {
		this.range = range;
	}
	
	public void removeFromRange(int card) {
		range[card] = 0;
	}
	
	public ArrayList<Integer> getValues() {
		return values;
	}
	
	public void addValue(int value) {
		values.add(value);
	}
}
