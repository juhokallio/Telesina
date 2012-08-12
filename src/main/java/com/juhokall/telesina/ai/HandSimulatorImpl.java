/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.Telesina;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.TelesinaValuedCard;
import com.juhokall.telesina.rules.TelesinaHandRater;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
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
	public TelesinaValuedCard getValuedCard(TelesinaHand hand) {
		Set simulatedCards = new HashSet<Integer>(playedCards);
		int randomizedCard, randomizedHand, cardsLeftInDeck = deck.size();
		randomizedCard = random.nextInt(cardsLeftInDeck--);
		simulatedCards.add(randomizedCard);
		hand.addNewCard(randomizedCard);
		int firstCard = randomizedCard;
		while (hand.getNumberOfCardsDealt() < Telesina.HAND_LENGTH) {
			do {
				randomizedCard = random.nextInt(cardsLeftInDeck--);
			} while (simulatedCards.contains(randomizedCard));
			simulatedCards.add(randomizedCard);
			hand.addNewCard(randomizedCard);
		}
		int handValue = rater.getTelesinaHandValue(hand);
		return new TelesinaValuedCard(firstCard, handValue);
	}
}
