/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Situation;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class TelesinaGameTest {

	TelesinaGame game;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		game = injector.getInstance(TelesinaGame.class);
	}

	@Test
	public void gameSetupTest1() {
		game.setNewGame(2);
		Situation situation = game.getSituation();
		Assert.assertEquals(2, situation.getPlayerIds().size());
	}
}
