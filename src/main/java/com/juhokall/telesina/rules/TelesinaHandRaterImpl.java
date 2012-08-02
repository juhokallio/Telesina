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
		int firstOne = Telesina.SUIT_COUNT - suit - 1;
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
			} else if (hits[rank] == 3) {
			} else if (hits[rank] == 4) {
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
		}
		return value;
	}

	private int getSuit(int card) {
		return card / Telesina.RANK_COUNT;
	}

	private int getRank(int card) {
		return card % Telesina.RANK_COUNT;
	}
}
