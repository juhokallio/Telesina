/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game;

import com.juhokall.telesina.game.action.Bet;
import com.juhokall.telesina.game.action.Call;
import com.juhokall.telesina.game.action.Check;
import com.juhokall.telesina.game.action.Fold;
import com.juhokall.telesina.game.action.Raise;
import com.juhokall.telesina.game.action.TelesinaGameAction;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.Telesina;
import com.juhokall.telesina.model.TelesinaHand;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author juho
 */
public class TelesinaGameImpl implements TelesinaGame {

	private Situation situation;
	private Set deck;
	private Map<SolutionType, TelesinaGameAction> solutionMethods;

	public TelesinaGameImpl() {

		solutionMethods = new EnumMap<SolutionType, TelesinaGameAction>(SolutionType.class);
		solutionMethods.put(SolutionType.BET, new Bet());
		solutionMethods.put(SolutionType.CALL, new Call());
		solutionMethods.put(SolutionType.CHECK, new Check());
		solutionMethods.put(SolutionType.FOLD, new Fold());
		solutionMethods.put(SolutionType.RAISE, new Raise());
	}

	@Override
	public Situation solveSituation(Solution solution) {
		SolutionType type = solution.getSolutionType();
		TelesinaGameAction action = solutionMethods.get(type);
		action.solve(situation, solution);
		return situation;
	}


	@Override
	public void dealCardForPlayer(int card, int playerNumber) {
		Player player = situation.getPlayer(playerNumber);
		TelesinaHand oldHand = player.getHand();
		oldHand.addNewCard(card);
		deck.remove(card);
	}

	@Override
	public Situation getSituation() {
		return situation;
	}

	@Override
	public void setNewGame(int numberOfPlayers) {
		deck = new HashSet();
		for (int i = 0; i < Telesina.DECK_LENGTH; i++) {
			deck.add(i);
		}
		situation = new Situation(numberOfPlayers);
		System.out.println("foo " + situation.toString());
	}

	@Override
	public Set getDeck() {
		return deck;
	}
}
