/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;

/**
 *
 * @author juho
 */
public class TelesinaHand {

	private int[] cards;
	private int numberOfCardsDealt;

	public TelesinaHand() {
		cards = new int[Telesina.HAND_LENGTH];
	}

	public TelesinaHand(TelesinaHand source) {
		this(source.cards, source.numberOfCardsDealt);
	}

	public TelesinaHand(int[] cards) {
		this();
		int inputSize = cards.length;
		if (inputSize <= Telesina.HAND_LENGTH) {
			for (int i = 0; i < inputSize; i++) {
				this.cards[i] = cards[i];
			}
			numberOfCardsDealt = inputSize;
		} else {
			System.out.println("Too long hand.");
		}
	}

	public TelesinaHand(int[] cards, int handLength) {
		this.cards = cards;
		numberOfCardsDealt = handLength;
	}

	public int[] getCards() {
		return cards;
	}

	public void setCards(int[] cards) {
		this.cards = cards;
	}

	public int getNumberOfCardsDealt() {
		return numberOfCardsDealt;
	}

	public void setNumberOfCardsDealt(int numberOfCardsDealt) {
		this.numberOfCardsDealt = numberOfCardsDealt;
	}

	public void addNewCard(int card) {
		if (numberOfCardsDealt < Telesina.HAND_LENGTH) {
			cards[numberOfCardsDealt] = card;
			numberOfCardsDealt++;
		}
	}
}
