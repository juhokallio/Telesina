/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The hand range each player shall have.
 * @author juho
 */
public class HandRange {

	private final static int ORIGINAL_WEIGHT = 100;
	private List<Integer> values;
	private int[] range;

	/**
	 * Constructor
	 */
	public HandRange() {
		range = new int[Telesina.DECK_LENGTH];
		for (int i = 0; i < Telesina.DECK_LENGTH; i++) {
			range[i] = ORIGINAL_WEIGHT;
		}
		values = new ArrayList<Integer>();
	}

	/**
	 *	The cloning method.
	 * @return clone
	 */
	@Override
	public HandRange clone() {
		HandRange clone = new HandRange();
		List newValues = new ArrayList<Integer>();
		Collections.copy(values, newValues);
		clone.setValues(values);
		clone.setRange(range);
		return clone;
	}

	/**
	 * Sorts the range's values.
	 */
	public void sortValues() {
		Collections.sort(values);
	}

	/**
	 * Gives the weighted tendencies of each card.
	 * @return Array of the probability of each card. 
	 */
	public int[] getRange() {
		return range;
	}

	/**
	 * Sets the range.
	 * @param range Array of the probability of each card. 
	 */
	public void setRange(int[] range) {
		this.range = range;
	}

	/**
	 * Sets the list of values that a hand in the range might get.
	 * @param values The list of the values.
	 */
	public void setValues(List<Integer> values) {
		this.values = values;
	}

	/**
	 *	Removes a card from range.
	 * @param card The card that gets removed.
	 */
	public void removeFromRange(int card) {
		range[card] = 0;
	}

	/**
	 *	Gives the list of the values a hand in the range might get.
	 * @return The list of the values.
	 */
	public List<Integer> getValues() {
		return values;
	}

	/**
	 * Adds a value a hand in the range might get.
	 * @param value Value a hand might get.
	 */
	public void addValue(int value) {
		values.add(value);
	}
}
