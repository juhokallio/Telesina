/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.TelesinaHand;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaAITest {
		TelesinaAI ai;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		ai = injector.getInstance(TelesinaAI.class);
	}

	@Test
	public void aiTest1() {
		Situation situation = new Situation(2);
		situation.setStreet(2);
		situation.addToPot(10);
		Player p1 = situation.getPlayer(0);
		Player p2 = situation.getPlayer(1);
		int[] h1 = {2,6,8,11,18};
		int[] h2 = {30,26,28,29,27};
		
		p1.setHand(new TelesinaHand(h1));
		p2.setHand(new TelesinaHand(h2));
		situation.setLastSolution(new Solution(SolutionType.BET));
		Solution solution = ai.getSolution(situation, 1);
		Assert.assertEquals(SolutionType.FOLD, solution.getSolutionType());
	}

}
