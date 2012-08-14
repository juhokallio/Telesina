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

	public Tactic(int[] actionPercentages) {
		this.actionPercentages = actionPercentages;
	}

	public Tactic() {
		actionPercentages = new int[Telesina.ACTION_TYPE_COUNT];
	}

	public int[] getActionPercentages() {
		return actionPercentages;
	}

	public void setActionPercentages(int[] actionPercentages) {
		this.actionPercentages = actionPercentages;
	}

	public int getPercentage(SolutionType action) {
		return actionPercentages[action.getOrderNumber()];
	}	

	public void setPercentage(SolutionType action, int percentage) {
		actionPercentages[action.getOrderNumber()] = percentage;
	}
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
