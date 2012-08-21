/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.juhokall.telesina.game.TelesinaGameImpl;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.core.Telesina;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author juho
 */
//public class PlayableTelesinaGameImpl extends TelesinaGameImpl implements PlayableTelesinaGame {
//
//	private Random random;
//	private Situation situation;
//	private int street;
//	private Set deck;
//
//        
//	@Override
//	public void setNewGame(int numberOfPlayers) {
//		super.setNewGame(numberOfPlayers);
//		situation = super.getSituation();
//		random = new Random();
//		deck = super.getDeck();
//	}
//
//	@Override
//	public void dealNextStreet() {
//		int cardsForTheStreet = Telesina.CARDS_DEALT_ON_STREET[street];
//		int card;
//		if (street < Telesina.NORMAL_STREET_COUNT) {
//			for (int playerId : situation.getPlayerIds()) {
//				for (int i = 0; i < cardsForTheStreet; i++) {
//					card = random.nextInt(deck.size());
//					deck.remove(card);
//					super.dealCardForPlayer(card, playerId);
//				}
//			}
//		} else if (street == Telesina.NORMAL_STREET_COUNT) {
//			card = random.nextInt(deck.size());
//			for (int playerId : situation.getPlayerIds()) {
//				super.dealCardForPlayer(card, playerId);
//			}
//		} else {
//		}
//		street++;
//	}
//}
