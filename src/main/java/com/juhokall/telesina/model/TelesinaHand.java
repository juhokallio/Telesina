/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;
import java.util.Collections;

/**
 * Represents a hand.
 * @author juho
 */
public class TelesinaHand {

	private int[] cards;
	private int numberOfCardsDealt;

	/**
	 * Constructor
	 */
	public TelesinaHand() {
		cards = new int[Telesina.HAND_LENGTH];
	}

	/**
	 * Constructor
	 * @param source Hand that gets copied.
	 */
	public TelesinaHand(TelesinaHand source) {
		this(source.cards, source.numberOfCardsDealt);
	}

	/**
	 * Constructor
	 * @param cards The array that contains the cards.
	 */
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

	/**
	 * Constructor
	 * @param cards The array that contains the cards.
	 * @param handLength The length of the hand.
	 */
	public TelesinaHand(int[] cards, int handLength) {
		this.cards = cards.clone();
		numberOfCardsDealt = handLength;
	}
	/**
	 * Get card of the specific index.
	 * @param index The index of the card.
	 * @return The card.
	 */
	public int getCard(int index) {
		return cards[index];
	}

	/**
	 *	Gives the cards.
	 * @return The array that contains the cards. 
	 */
	public int[] getCards() {
		return cards;
	}

	/**
	 * Sets the array of the cards.
	 * @param cards The array that contains the cards.
	 */
	public void setCards(int[] cards) {
		this.cards = cards;
	}

	/**
	 * Gives the number of the cards dealt.
	 * @return The number of the cards dealt.
	 */
	public int getNumberOfCardsDealt() {
		return numberOfCardsDealt;
	}

	/**
	 *	Sets the number of cards dealt.
	 * @param numberOfCardsDealt The number of cards dealt.
	 */
	public void setNumberOfCardsDealt(int numberOfCardsDealt) {
		this.numberOfCardsDealt = numberOfCardsDealt;
	}

	/**
	 * Adds a new card to the hand.
	 * @param card The new card.
	 */
	public void addNewCard(int card) {
		if (numberOfCardsDealt < Telesina.HAND_LENGTH) {
			cards[numberOfCardsDealt] = card;
			numberOfCardsDealt++;
		}
	}
}
