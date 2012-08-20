/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class SituationTest {

	@Test
	public void situationCloneTest1() {
		Situation situation = new Situation(2);

		Situation clone = situation.clone();
		Assert.assertEquals(situation.getPotSize(), clone.getPotSize());
		Assert.assertEquals(situation.getActivePlayer().getLastSolution().getSolutionType(), clone.getActivePlayer().getLastSolution().getSolutionType());
		Assert.assertEquals(situation.getPlayersLeft(), clone.getPlayersLeft());
		Assert.assertEquals(situation.getStreet(), clone.getStreet());
	}
}
