/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.ai.TelesinaAI;
import com.juhokall.telesina.io.PlayableTelesinaGame;
import com.juhokall.telesina.io.TelesinaHumanizer;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.TelesinaHand;
import java.util.Scanner;

/**
 *
 * @author juho
 */
public class TelesinaArena {

	private static PlayableTelesinaGame game;
	private static TelesinaHumanizer humanizer;
	private static TelesinaAI ai;
	private static Scanner scanner;
	private final static int HERO= 0;
	private final static int VILLAIN= 1;
	private final static int PLAYER_COUNT = 2;
	private static int villainsHoleCard;



	public static void main(String[] args) {
		initialize();
		
		game.dealNextStreet();
		int holeCard = game.dealHoleCard(HERO);
		printVillainHand();
		printHeroHand(holeCard);	 
		int activePlayer = game.getActivePlayer();
		if(activePlayer == HERO) {
			processHeroTurn();
		} else {
			processVillainTurn();
		}
	}
private static void processHeroTurn() {
	System.out.println("It is your turn");
}

	private static void processVillainTurn() {
		System.out.println("It is opponents turn.");
		Situation situation = game.getSituation();
		Solution solution = ai.getSolution(situation, villainsHoleCard);
		System.out.println(solution.getSolutionType());
		game.solveSituation(situation, solution);
	}
	private static void printHeroHand(int holeCard){
 		String holeCardHumanized = humanizer.humanizeCard(holeCard);
		String output = "Your cards: (" + holeCardHumanized + ") ";
		output += getPlayersHand(HERO);
		System.out.println(output);
	}
	

	private static void printVillainHand() {
		String output = "Opponents cards: ( ) ";
		output += getPlayersHand(VILLAIN);
		System.out.println(output);
		
	}
	
	private static String getPlayersHand(int playerNumber) {
		String output = "";
		TelesinaHand hand = game.getPlayersHand(playerNumber);
		for(int cardIndex = 0; cardIndex < hand.getNumberOfCardsDealt(); cardIndex++) {
			String humanizedCard = humanizer.humanizeCard(hand.getCard(cardIndex));
			output += humanizedCard + " ";
		}	
		return output;
		
	}
		
	private static void initialize() {
		Injector injector = Guice.createInjector();
		game = injector.getInstance(PlayableTelesinaGame.class);
		humanizer = injector.getInstance(TelesinaHumanizer.class);
		scanner = new Scanner(System.in);
		ai = injector.getInstance(TelesinaAI.class);
		game.setNewGame(PLAYER_COUNT);
		villainsHoleCard = game.dealHoleCard(VILLAIN);	
	}
}
