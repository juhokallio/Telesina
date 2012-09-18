/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.core.Telesina;
import com.juhokall.telesina.rules.TelesinaHandRater;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Class that simulates one hand at a time. The basic implemention.
 * @author juho
 */
public class HandSimulatorImpl implements HandSimulator {

	private List<Integer> deck;
	private Random random;
	private TelesinaHandRater rater;
	private Set playedCards;
	
	@Inject
	public HandSimulatorImpl(TelesinaHandRater rater) {
		this.rater = rater;
		this.deck = new ArrayList<Integer>();
		playedCards = new HashSet<Integer>();
		for (int i = 0; i < Telesina.DECK_LENGTH; i++) {
			deck.add(i);
		}
		random = new Random();
	}
	
	@Override
	public void addPlayedCard(int card) {
		playedCards.add(card);
	}

	@Override
	public void addPlayedHand(TelesinaHand hand) {
		for (int card : hand.getCards()) {
			playedCards.add(card);
		}
	}

	@Override
	public int getValue(TelesinaHand hand) {
		Set simulatedCards = new HashSet<Integer>(playedCards);
		TelesinaHand newHand = new TelesinaHand(hand);
		int randomizedCard, randomizedHand;
		do {
			randomizedCard = random.nextInt(Telesina.DECK_LENGTH);
		} while (simulatedCards.contains(randomizedCard));
		return getValue(hand, randomizedCard);
	}

	@Override
	public int getValue(TelesinaHand hand, int nextCard) {
		Set simulatedCards = new HashSet<Integer>(playedCards);
		TelesinaHand newHand = new TelesinaHand(hand);
		int randomizedCard;
		simulatedCards.add(nextCard);
		newHand.addNewCard(nextCard);
		while (newHand.getNumberOfCardsDealt() < Telesina.HAND_LENGTH) {
			do {
				randomizedCard = random.nextInt(Telesina.DECK_LENGTH);
			} while (simulatedCards.contains(randomizedCard));
			simulatedCards.add(randomizedCard);
			newHand.addNewCard(randomizedCard);
		}
		return rater.getTelesinaHandValue(newHand);
	}
}
