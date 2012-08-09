/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.Telesina;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaGameActionTest {

	TelesinaGameAction action;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		action = injector.getInstance(TelesinaGameAction.class);
	}

	@Test
	public void betTest1() {
		int playerCount = 2, betSize = 2;
		Situation situation = new Situation(playerCount);
		Solution solution = new Solution(SolutionType.BET, betSize);
		action.solve(situation, solution);
		Assert.assertEquals(playerCount * Telesina.DEFAULT_ANTE + betSize, situation.getPotSize());
	}

	@Test
	public void foldTest1() {
		int playerCount = 2;
		Situation situation = new Situation(playerCount);
		Solution solution = new Solution(SolutionType.FOLD);
		action.solve(situation, solution);
		Assert.assertEquals(playerCount - 1, situation.getPlayerCount());
	}

	@Test
	public void callTest1() {
		int playerCount = 2, betSize = 20;
		Situation situation = new Situation(playerCount);
		Player player = situation.getActivePlayer();
		int originalStack = player.getStack();
		Solution solution = new Solution(SolutionType.CALL, betSize);
		action.solve(situation, solution);
		Assert.assertEquals(originalStack - betSize, player.getStack());
	}
}
