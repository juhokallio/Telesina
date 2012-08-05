/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.juhokall.telesina.model.Telesina;

/**
 *
 * @author juho
 */
public class TelesinaHandRaterImpl implements TelesinaHandRater {

	public int getHighcardValue(int card) {
		int suit = getSuit(card);
		int rank = getRank(card);
		int firstOne = suit;//Telesina.SUIT_COUNT - suit - 1;
		int value = firstOne + rank * (Telesina.SUIT_COUNT);
		return value;//card - suit * Telesina.RANK_COUNT;
	}

	public int getPairhandValue(int[] hand) {
		int[] hits = new int[Telesina.RANK_COUNT];
		int value = 0;
		for (int card : hand) {
			int rank = getRank(card);
			hits[rank]++;
			if (hits[rank] == 2) {
				value = getPairValue(rank, value);
			} else if (hits[rank] == 3) {
				value = getSetValue(rank, value);
			} else if (hits[rank] == 4) {
				value = getSquadsValue(rank);
			}
		}
		return value;
	}

	private int getPairValue(int rank, int originalValue) {
		int value = 0;
		if (originalValue == 0) {
			value = Telesina.PAIR_VALUE + rank;
		} else if (originalValue < Telesina.PAIR_VALUE + Telesina.RANK_COUNT) {
			int otherPairRank = originalValue - Telesina.PAIR_VALUE;
			value = Telesina.TWO_PAIR_VALUE;
			if (rank > otherPairRank) {
				value += Telesina.RANK_COUNT * rank + otherPairRank;
			} else {
				value += Telesina.RANK_COUNT * otherPairRank + rank;
			}
		} else {
			int originalTwoPairValue = originalValue - Telesina.TWO_PAIR_VALUE;
			int originalWeakerPair = originalTwoPairValue % Telesina.RANK_COUNT;
			int originalStrongerPair = originalTwoPairValue / Telesina.RANK_COUNT;
			if(rank > originalWeakerPair){
				if(rank < originalStrongerPair){
					value = Telesina.TWO_PAIR_VALUE + originalStrongerPair * Telesina.RANK_COUNT + rank; 
				}else {
					value = Telesina.TWO_PAIR_VALUE + rank * Telesina.RANK_COUNT + originalStrongerPair;
				}
			}
		}
		return value;
	}

	private int getSetValue(int rank, int originalValue) {
		int value = 0;
		

		return value;
	}
	private int getSquadsValue(int rank) {
		int value = 0;
		

		return value;
	}

	
	
	private int getSuit(int card) {
		return card / Telesina.RANK_COUNT;
	}

	private int getRank(int card) {
		return card % Telesina.RANK_COUNT;
	}
}
