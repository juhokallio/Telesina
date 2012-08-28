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
import com.juhokall.telesina.model.SolutionType;
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
	private final static int HERO = 0;
	private final static int VILLAIN = 1;
	private final static int PLAYER_COUNT = 2;
	private final static int ANTE_SIZE = 2;
	private static int villainsHoleCard;
	private static Situation situation;

	public static void main(String[] args) {
		initialize();

		game.dealNextStreet();
		int holeCard = game.dealHoleCard(HERO);
		takeAntes();
		System.out.println("");
		printVillainHand();
		printPlayersStack(VILLAIN);
		printHeroHand(holeCard);
		printPlayersStack(HERO);
		printPotSize();
		System.out.println("");
		do {
			int activePlayer = game.getActivePlayer();
			if (activePlayer == HERO) {
				processHeroTurn();
			} else {
				processVillainTurn();
			}
		} while (situation.getPlayersLeft() > 0);
	}

	private static void processHeroTurn() {
		System.out.println("It is your turn");
		String decision = scanner.nextLine();
		while(!processDecision(decision)){
			decision = scanner.nextLine();
		}
		}
	private static boolean processDecision(String decision) {
		if(decision.equals("c")) {
			situation = game.solveSituation(situation, new Solution(SolutionType.CHECK));
		}	
		return true;
	}

	private static void takeAntes() {
		situation = game.solveSituation(situation, new Solution(SolutionType.TAKE_ANTES, ANTE_SIZE));
		for (int i = 0; i < PLAYER_COUNT; i++) {
			System.out.println(ANTE_SIZE + "$ taken as ante.");
		}
	}

	private static void printPotSize() {
		System.out.println("Pot size: " + situation.getPotSize() + "$");
	}

	private static void processVillainTurn() {
		System.out.println("It is opponents turn.");
		Solution solution = ai.getSolution(situation, villainsHoleCard);
		SolutionType solutionType = solution.getSolutionType();
		String output = solutionType.name();
		if (solutionType == SolutionType.BET || solutionType == SolutionType.RAISE) {
			output += " " + solution.getSolutionSize() + "$";
		}
		System.out.println(output);
		game.solveSituation(situation, solution);
	}

	private static void printHeroHand(int holeCard) {
		String holeCardHumanized = humanizer.humanizeCard(holeCard);
		String output = "Your cards: (" + holeCardHumanized + ") ";
		output += getPlayersHand(HERO);
		System.out.println(output);
	}

	private static void printPlayersStack(int playerNumber) {
		System.out.println("Stack: " + situation.getPlayer(playerNumber).getStack() + "$");
	}

	private static void printVillainHand() {
		String output = "Opponent's cards: ( ) ";
		output += getPlayersHand(VILLAIN);
		System.out.println(output);

	}

	private static String getPlayersHand(int playerNumber) {
		String output = "";
		TelesinaHand hand = game.getPlayersHand(playerNumber);
		for (int cardIndex = 0; cardIndex < hand.getNumberOfCardsDealt(); cardIndex++) {
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
		situation = game.getSituation();
	}
}
