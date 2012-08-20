/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Tactic;
import com.juhokall.telesina.model.core.Telesina;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TacticTest {
	@Test
	public void getActionTest1() {
		Tactic tactic = new Tactic(AISettings.LAZY_1ST_ACTION_PERCENTAGES[0]);
		SolutionType solutionType = tactic.getAction(1);	
		SolutionType expectedSolutionType = null;
		for(int i = 0; i < AISettings.LAZY_1ST_ACTION_PERCENTAGES[0].length; i++){
			if(AISettings.LAZY_1ST_ACTION_PERCENTAGES[0][i] > 0) {
				expectedSolutionType = Telesina.SOLUTION_TYPES[i];
			}
		}
		Assert.assertEquals(expectedSolutionType, solutionType);
	}
	@Test
	public void getActionTest2() {
		Tactic tactic = new Tactic(AISettings.LAZY_1ST_ACTION_PERCENTAGES[0]);
		int relativeHandStrength = 97;
		SolutionType solutionType = tactic.getAction(relativeHandStrength);
		int handledArea = 0;
		SolutionType expectedSolutionType = null;
		for(int i = 0; i < AISettings.LAZY_1ST_ACTION_PERCENTAGES[0].length; i++){
			handledArea = AISettings.LAZY_1ST_ACTION_PERCENTAGES[0][i];
			if(handledArea >= relativeHandStrength) {
				expectedSolutionType = Telesina.SOLUTION_TYPES[i];
				break;
			}
		}
		Assert.assertEquals(expectedSolutionType, solutionType);
	}
}
