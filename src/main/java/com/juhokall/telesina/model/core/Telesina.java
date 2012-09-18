/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.core;

import com.juhokall.telesina.model.SolutionType;

/**
 * A class that contains constants used everywhere with Telesina.
 * @author juho
 */
public class Telesina {
	/**
	 * Telesina hand length.
	 */
	public static final int HAND_LENGTH = 6;
	/**
	 * The number of cards that gets included to the rated hand.
	 */
	public static final int RATEABLE_HAND_LENGTH = 5;
	/**
	 * The deck length in Telesina.
	 */
	public static final int DECK_LENGTH = 32;
	/**
	 * The suits of the cards.
	 */
	public static final String[] SUITS = {"Spades", "Clubs", "Diamonds", "Hearts" };
	/**
	 * Short form of the suits.
	 */
	public static final String[] SUITS_SHORT = {"S", "C", "D", "H" };
	/**
	 * The ranks of the cards in Telesina.
	 */
	public static final String[] RANKS = {"seven", "eight", "nine", "ten", "Jack", "Queen", "King", "Ace"};
	/**
	 * The short form the cards.
	 */
	public static final String[] RANKS_SHORT = {"7", "8", "9", "T", "J", "Q", "K", "A"};
	/**
	 *	The number of the ranks.
	 */
	public static final int RANK_COUNT = 8;
	/**
	 * The number of the suits.
	 */
	public static final int SUIT_COUNT = 4;
	/**
	 * The minimum value of a pair.
	 */
	public static int PAIR_VALUE = 32;
	/**
	 * The minimum value of two pairs.
	 */
	public static int TWO_PAIR_VALUE = 288;
	/**
	 * The minimum value of a straight.
	 */
	public static int STRAIGHT_VALUE = 500; //Not tightest
	/**
	 * The minimum value of a flush.
	 */
	public static int FLUSH_VALUE = 1000; //Same
	/**
	 * The number of the streets in Telesina.
	 */
	public static int STREET_COUNT = 4;
	/**
	 * The number of the normal streets in Telesina.
	 */
	public static int NORMAL_STREET_COUNT = 3;
	/**
	 * The number of the cards dealt in each street.
	 */
	public static int[] CARDS_DEALT_ON_STREET = {1, 1, 1};
	/**
	 * The default starting stack of each player.
	 */
	public static int DEFAULT_STACK = 100;
	/**
	 * The default ante.
	 */
	public static int DEFAULT_ANTE = 1;
	/**
	 * The number of standard action types.
	 */
	public static int ACTION_TYPE_COUNT = 5;
	/**
	 * Array of the solution types.
	 */
	public static SolutionType[] SOLUTION_TYPES = {SolutionType.BET, SolutionType.CALL, SolutionType.CHECK, SolutionType.FOLD, SolutionType.RAISE};
}
