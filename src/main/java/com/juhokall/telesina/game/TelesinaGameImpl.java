/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game;

import com.google.inject.Inject;
import com.juhokall.telesina.game.action.TelesinaGameAction;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.core.Telesina;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author juho
 */
public class TelesinaGameImpl implements TelesinaGame {

	private Situation situation;
	private Set deck;
	private TelesinaGameAction action;

	@Inject
	public TelesinaGameImpl(TelesinaGameAction action) {
		this.action = action;
		this.situation = new Situation(2);
	}

	@Override
	public Situation solveSituation(Situation s, Solution solution) {
		Situation nextSituation = s.clone();
		action.solve(nextSituation, solution);
		if (nextSituation.getPlayerCount() <= 1) {
		} else if (nextSituation.getPlayersLeft() == 0) {
			nextSituation.moveToNextStreet();
		} else {
			setNextPlayer(nextSituation);
			if (nextSituation.getLastSolution().getSolutionType() != SolutionType.TAKE_ANTES || solution.getSolutionType() != SolutionType.CALL) {
				nextSituation.setLastSolution(solution);
			}
		}
		return nextSituation;
	}

	private void setNextPlayer(Situation situation) {
		int nextActivePlayer = situation.getNonActivePlayerIds()[0];
		situation.setActivePlayer(nextActivePlayer);
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
	}

	@Override
	public void setNewGame(Situation situation) {
		this.situation = situation;
	}

	@Override
	public Set getDeck() {
		return deck;
	}
}
