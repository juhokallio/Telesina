/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.Inject;
import com.juhokall.telesina.model.core.Telesina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juho
 */
public class TelesinaRulesImpl implements TelesinaRules {

	@Inject
	TelesinaHandRater handRater;
	
	public int getWinner(int[][] hands) {
//		List<Map<String, Integer>> allResults = new ArrayList<Map<String, Integer>>();//[hands.length]();
		int handCount = hands.length;
		int[][] suits = new int[handCount][Telesina.SUIT_COUNT];
		int[][] ranks = new int[handCount][Telesina.RANK_COUNT];
		int[] points = new int[handCount];
//		for(int i = 0; i < handsCount; i++) {
//			allResults.add(new HashMap<String, Integer>());
//		}
		if(!handsAreValid(hands)) {
			return -2;
		}
		int card, suit, rank;
		for(int cardIndex = 0; cardIndex < Telesina.HAND_LENGTH; cardIndex++) {
			for(int handIndex = 0; handIndex < handCount; handIndex++) {
				card = hands[handIndex][cardIndex];
				suit = card / Telesina.RANK_COUNT;
				rank = card % Telesina.DECK_LENGTH;
				
				if(points[handIndex] < Telesina.DECK_LENGTH) {
					points[handIndex] = Telesina.DECK_LENGTH -suit * Telesina.RANK_COUNT;
				}
					
				suits[handIndex][suit]++;
				ranks[handIndex][rank]++;	
			}	
		}


		

		return -1;
	}

	
	//-1: no flush
	private int getBestFlush(int[][] suits) {
		for(int handIndex = 0; handIndex < suits.length; handIndex++) {
			for(int suitIndex = 0; suitIndex < Telesina.SUIT_COUNT; suitIndex++) {
				if(suits[handIndex][suitIndex] >= 5) {
					return handIndex;
				}
			}
		}
		return -1;
	}
//	private int getBestPair(int[][] ranks, int[][] hands) {
//		for(int handIndex = 0; handIndex < hands.length; handIndex++) {
//			for(int rankIndex = 0; rankIndex < Telesina.RANK_COUNT; rankIndex++) {
//				if(ranks[handIndex][suitIndex] >= 5) {
//					return handIndex;
//				}
//			}
//		}
//	}

	private String getSuit(int card) {
		int suitIndex = card / Telesina.RANK_COUNT;
		return Telesina.SUITS[suitIndex];	
	}

//	private String getRank(int card) {
//		int rankIndex = card % Telesina.RANK_COUNT;
//		return Tel
//	}
	
	private Boolean handsAreValid(int[][] hands) {
		Boolean handsAreValid = true;
		for(int[] hand : hands) {
			if(hand.length != Telesina.HAND_LENGTH) {
			System.out.println("Hand length was wrong.");
				return false;
			}
		}
		int[] cardsInPlay = new int[Telesina.DECK_LENGTH];
		int card;
		for (int cardIndex = 0; cardIndex < Telesina.HAND_LENGTH; cardIndex++) {
			for (int handIndex = 0; handIndex < hands.length; handIndex++) {
				card = hands[handIndex][cardIndex];
				if (card >= Telesina.DECK_LENGTH || 1 == cardsInPlay[card]) {
					System.out.println("Two of the hands had the same card.");
					return false;
				}
				hands[handIndex][cardIndex] = 1;
			}
		}
		return handsAreValid;
	}
}
