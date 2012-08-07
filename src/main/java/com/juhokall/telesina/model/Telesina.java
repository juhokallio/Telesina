/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

/**
 *
 * @author juho
 */
public class Telesina {
	public static final int HAND_LENGTH = 6;
	public static final int DECK_LENGTH = 32;
	public static final String[] SUITS = {"Spades", "Clubs", "Diamonds", "Hearts" };
	public static final String[] SUITS_SHORT = {"S", "C", "D", "H" };
	public static final String[] RANKS = {"seven", "eight", "nine", "ten", "Jack", "Queen", "King", "Ace"};
	public static final String[] RANKS_SHORT = {"7", "8", "9", "T", "J", "Q", "K", "A"};
	public static final int RANK_COUNT = 8;
	public static final int SUIT_COUNT = 4;
	public static int PAIR_VALUE = 32;
	public static int TWO_PAIR_VALUE = 40;
	public static int STREET_COUNT = 4;
	public static int NORMAL_STREET_COUNT = 3;
	public static int[] CARDS_DEALT_ON_STREET = {2, 1, 1};
	public static int DEFAULT_STACK = 100;
	public static int DEFAULT_ANTE = 1;
}
