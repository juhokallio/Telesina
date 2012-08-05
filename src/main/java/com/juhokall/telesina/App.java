package com.juhokall.telesina;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.game.TelesinaGame;
import com.juhokall.telesina.io.PlayableTelesinaGame;
import com.juhokall.telesina.io.PlayableTelesinaGameImpl;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Telesina;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {

	private static PlayableTelesinaGame game;
	
	public static void main(String[] args) {
		init();
		game.setNewGame(2);
		Situation situation = game.getSituation();
		for(int street = 0; street < Telesina.NORMAL_STREET_COUNT; street++) {
			game.dealNextStreet();
		}
		
	}

	private static void init() {
		Injector injector = Guice.createInjector();
		game = injector.getInstance(PlayableTelesinaGameImpl.class);
	}
}
