/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.model.AISettings;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.TelesinaValuedCard;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerTest {

	TelesinaGame game;
	TelesinaRangeAnalyzer rangeAnalyzer;

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
		HandRange [] ranges = rangeAnalyzer.getRanges(situation);
		Assert.assertEquals(playerCount, ranges.length);
		List<TelesinaValuedCard> handValues = ranges[0].getHandValues();
		Assert.assertTrue(handValues.get(0).getValue() < handValues.get(handValues.size() - 1).getValue());
		Assert.assertEquals(AISettings.RANGE_ITERATIONS, handValues.size());
	}

	@Test
	public void analyzerTest2() {
		int removedCard = 7, otherCard = 8;
		int playerCount = 2;
			game.setNewGame(playerCount);
		game.dealCardForPlayer(3, 0);
		game.dealCardForPlayer(1, 0);
		game.dealCardForPlayer(16, 0);
		game.dealCardForPlayer(19, 0);
		
		game.dealCardForPlayer(31, 1);
		game.dealCardForPlayer(23, 1);
		Situation situation = game.getSituation();
		situation.getPlayer(0).getRange().removeFromRange(removedCard);
		HandRange [] ranges = rangeAnalyzer.getRanges(situation);
		int removedCardCount = 0, otherCardCount = 0;	
		for(TelesinaValuedCard card : ranges[0].getHandValues()) {
			if(card.getCard() == removedCard) {
				removedCardCount++;
			}else if(card.getCard() == otherCard) {
				otherCardCount++;
			}	
		}
		Assert.assertTrue(removedCardCount < otherCardCount);
	}
}
