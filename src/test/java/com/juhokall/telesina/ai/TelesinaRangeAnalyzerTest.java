/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.AISettings;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerTest {

	private TelesinaGame game;
	private TelesinaRangeAnalyzer rangeAnalyzer;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		rangeAnalyzer = injector.getInstance(TelesinaRangeAnalyzer.class);
		game = injector.getInstance(TelesinaGame.class);
	}

	@Test
	public void analyzerTest1() {
		int playerCount = 2;
		game.setNewGame(playerCount);
		game.dealCardForPlayer(3, 0);
		game.dealCardForPlayer(1, 0);
		game.dealCardForPlayer(31, 1);
		game.dealCardForPlayer(23, 1);
		Situation situation = game.getSituation();
		HandRange[] ranges = rangeAnalyzer.getRanges(situation);
		Assert.assertEquals(playerCount, ranges.length);
		List<Integer> values = ranges[0].getValues();
		Assert.assertTrue(values.get(0) < values.get(values.size() - 1));
		Assert.assertEquals(AISettings.RANGE_ITERATIONS, values.size());
	}
}
