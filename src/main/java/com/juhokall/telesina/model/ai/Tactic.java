/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.core.Telesina;

/**
 *
 * @author juho
 */
public class Tactic {
	private int[] actionPercentages;

	/**
	 *
	 * @param actionPercentages
	 */
	public Tactic(int[] actionPercentages) {
		this.actionPercentages = new int[Telesina.ACTION_TYPE_COUNT];
		for(int i = 0; i < Telesina.ACTION_TYPE_COUNT; i++) {
			this.actionPercentages[i] = actionPercentages[i];
		}
	}

	/**
	 *
	 */
	public Tactic() {
		actionPercentages = new int[Telesina.ACTION_TYPE_COUNT];
	}

	/**
	 *
	 * @return
	 */
	public int[] getActionPercentages() {
		return actionPercentages;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public Tactic clone() {
		Tactic clone = new Tactic();
		int[] clonePercentages = new int[actionPercentages.length];
		for(int i = 0; i < actionPercentages.length; i++) {
			clonePercentages[i] = actionPercentages[i];
		}
		clone.setActionPercentages(clonePercentages);
		return clone;
	}

	/**
	 *
	 * @param actionPercentages
	 */
	public void setActionPercentages(int[] actionPercentages) {
		this.actionPercentages = actionPercentages;
	}

	/**
	 *
	 * @param action
	 * @return
	 */
	public int getPercentage(SolutionType action) {
		return actionPercentages[action.getOrderNumber()];
	}	

	/**
	 *
	 * @param action
	 * @param percentage
	 */
	public void setPercentage(SolutionType action, int percentage) {
		actionPercentages[action.getOrderNumber()] = percentage;
	}
	/**
	 *
	 * @param nullToHundred
	 * @return
	 */
	public SolutionType getAction(int nullToHundred) {
		int percentage = 0;
		for(int i = 0; i < Telesina.ACTION_TYPE_COUNT - 1; i++) {
			percentage += actionPercentages[i];
			if(nullToHundred < percentage) {
				return Telesina.SOLUTION_TYPES[i]; 
			}
		}
		return Telesina.SOLUTION_TYPES[Telesina.ACTION_TYPE_COUNT - 1];
	}
}
