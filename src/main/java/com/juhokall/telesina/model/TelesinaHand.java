/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

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
		if(numberOfCardsDealt < Telesina.HAND_LENGTH) {
			cards[numberOfCardsDealt] = card;
			numberOfCardsDealt++;
		}
	}

}
